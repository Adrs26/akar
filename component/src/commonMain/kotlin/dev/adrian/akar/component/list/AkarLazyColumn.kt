package dev.adrian.akar.component.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarLazyColumn(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(AkarTheme.spacing.none),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: LazyListScope.() -> Unit
) {
    LazyColumn(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding.add(bottom = AkarTheme.spacing.medium),
        reverseLayout = false,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}

@Composable
fun PaddingValues.add(
    start: Dp = AkarTheme.spacing.none,
    top: Dp = AkarTheme.spacing.none,
    end: Dp = AkarTheme.spacing.none,
    bottom: Dp = AkarTheme.spacing.none
): PaddingValues {
    val direction = LocalLayoutDirection.current
    return PaddingValues(
        start = this.calculateStartPadding(direction) + start,
        top = this.calculateTopPadding() + top,
        end = this.calculateEndPadding(direction) + end,
        bottom = this.calculateBottomPadding() + bottom
    )
}

@Composable
fun PaddingValues.add(
    horizontal: Dp = AkarTheme.spacing.none,
    vertical: Dp = AkarTheme.spacing.none
): PaddingValues {
    val direction = LocalLayoutDirection.current
    return PaddingValues(
        start = this.calculateStartPadding(direction) + horizontal,
        top = this.calculateTopPadding() + vertical,
        end = this.calculateEndPadding(direction) + horizontal,
        bottom = this.calculateBottomPadding() + vertical
    )
}