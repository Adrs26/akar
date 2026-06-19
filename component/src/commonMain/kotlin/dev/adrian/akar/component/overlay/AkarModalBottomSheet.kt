package dev.adrian.akar.component.overlay

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.adrian.akar.component.layout.AkarAppBar
import dev.adrian.akar.component.layout.AkarScaffold
import dev.adrian.akar.core.theme.AkarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AkarModalBottomSheet(
    title: String,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        modifier = modifier,
        sheetState = sheetState,
        containerColor = AkarTheme.colors.surface,
        dragHandle = null
    ) {
        AkarScaffold(
            topBar = {
                AkarAppBar(
                    title = title,
                    navigationIcon = navigationIcon
                )
            }
        ) { innerPadding ->
            content(innerPadding)
        }
    }
}