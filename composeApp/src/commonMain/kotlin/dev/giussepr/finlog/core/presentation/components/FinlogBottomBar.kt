package dev.giussepr.finlog.core.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.giussepr.finlog.core.presentation.BottomBarRoute
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun FinlogBottomBar(navController: NavController) {
    val destinations: List<BottomBarRoute> = remember {
        listOf(
            BottomBarRoute.Home,
            BottomBarRoute.Transactions,
            BottomBarRoute.CreditCards,
            BottomBarRoute.Profile
        )
    }

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestinationRoute = backStackEntry?.destination?.route

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        destinations.forEach { destination ->
            val routeClassName = destination.route::class.simpleName ?: ""
            val isSelected = currentDestinationRoute?.contains(routeClassName) == true

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(route = destination.route) {
                        // Pop up to the start destination to avoid building up a large stack
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = null
                    )
                },
                label = { Text(text = stringResource(destination.title)) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    selectedTextColor = MaterialTheme.colorScheme.onSurface,
                    indicatorColor = MaterialTheme.colorScheme.secondaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    FinlogBottomBar(
        rememberNavController()
    )
}