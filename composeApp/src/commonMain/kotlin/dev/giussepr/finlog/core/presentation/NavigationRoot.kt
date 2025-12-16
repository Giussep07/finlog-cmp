package dev.giussepr.finlog.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.giussepr.finlog.core.presentation.components.FinlogBottomBar
import dev.giussepr.finlog.credit_cards.CreditCardsScreen
import dev.giussepr.finlog.home.presentation.HomeScreen
import dev.giussepr.finlog.profile.ProfileScreen
import dev.giussepr.finlog.transactions.TransactionsScreen
import finlog.composeapp.generated.resources.Res
import finlog.composeapp.generated.resources.ic_logo_white
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationRoot() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val bottomBarVisible = currentRoute?.let { route ->
        route.contains("Route.Home") ||
                route.contains("Route.Transactions") ||
                route.contains("Route.CreditCards") ||
                route.contains("Route.Profile")
    } ?: false

    val topBarVisible = bottomBarVisible

    Scaffold(
        topBar = {
            if (topBarVisible) {
                TopAppBar(
                    navigationIcon = {
                        Box(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .size(36.dp)
                                .background(MaterialTheme.colorScheme.primary, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.ic_logo_white),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    },
                    title = {
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = "Finlog",
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        titleContentColor = MaterialTheme.colorScheme.onBackground
                    )
                )
            }
        },
        bottomBar = {
            if (bottomBarVisible) {
                FinlogBottomBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Route.Home> {
                HomeScreen()
            }

            composable<Route.Transactions> {
                TransactionsScreen()
            }

            composable<Route.CreditCards> {
                CreditCardsScreen()
            }

            composable<Route.Profile> {
                ProfileScreen()
            }
        }
    }
}
