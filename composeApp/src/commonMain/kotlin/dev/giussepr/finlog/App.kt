package dev.giussepr.finlog

import androidx.compose.runtime.Composable
import dev.giussepr.finlog.core.presentation.NavigationRoot
import dev.giussepr.finlog.core.theme.FinlogTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    FinlogTheme {
        NavigationRoot()
    }
}
