package dev.adrian.akar.component.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import dev.adrian.akar.core.theme.AkarTheme
import kotlinx.coroutines.launch

@Composable
fun AkarTabPager(
    pagerState: PagerState,
    pages: List<AkarTabPage>,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
    ) {
        PrimaryTabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth(),
            containerColor = AkarTheme.colors.surface,
            contentColor = AkarTheme.colors.onSurface,
            indicator = {
                TabRowDefaults.PrimaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(pagerState.currentPage, true),
                    width = Dp.Unspecified,
                    color = AkarTheme.colors.primary
                )
            }
        ) {
            pages.forEachIndexed { index, page ->
                Tab(
                    text = {
                        Text(
                            text = page.title,
                            color = if (pagerState.currentPage == index) {
                                AkarTheme.colors.primary
                            } else {
                                AkarTheme.colors.onSurfaceVariant
                            },
                            style = AkarTheme.typography.headingSubtle
                        )
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { pageIndex ->
            pages[pageIndex].content()
        }
    }
}

data class AkarTabPage(
    val title: String,
    val content: @Composable () -> Unit
)