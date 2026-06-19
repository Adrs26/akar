package dev.adrian.akar.component.overlay

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import dev.adrian.akar.core.theme.AkarTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AkarNavigationSheet(
    onDismiss: () -> Unit,
    menus: List<AkarNavigationSheetMenu>,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState()
) {
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        shape = BottomSheetDefaults.HiddenShape,
        containerColor = AkarTheme.colors.surface,
        dragHandle = null,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(vertical = AkarTheme.spacing.medium)
        ) {
            menus.forEach { menu ->
                Text(
                    text = menu.label,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    onDismiss()
                                    menu.onClick()
                                }
                            }
                        }
                        .padding(
                            horizontal = AkarTheme.spacing.large,
                            vertical = AkarTheme.spacing.medium
                        ),
                    style = AkarTheme.typography.bodyFeatured
                )
            }
        }
    }
}

data class AkarNavigationSheetMenu(
    val label: String,
    val onClick: () -> Unit
)