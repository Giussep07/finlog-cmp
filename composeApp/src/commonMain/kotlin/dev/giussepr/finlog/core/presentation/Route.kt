package dev.giussepr.finlog.core.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.ui.graphics.vector.ImageVector
import finlog.composeapp.generated.resources.Res
import finlog.composeapp.generated.resources.credit_cards
import finlog.composeapp.generated.resources.home
import finlog.composeapp.generated.resources.profile
import finlog.composeapp.generated.resources.transactions
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.StringResource

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object Transactions : Route

    @Serializable
    data object CreditCards : Route

    @Serializable
    data object Profile : Route
}

sealed class BottomBarRoute(
    val route: Route,
    val icon: ImageVector,
    val title: StringResource
) {

    data object Home : BottomBarRoute(
        route = Route.Home,
        icon = Icons.Default.Home,
        title = Res.string.home
    )

    data object Transactions : BottomBarRoute(
        route = Route.Transactions,
        icon = Icons.Default.SwapHoriz,
        title = Res.string.transactions
    )

    data object CreditCards : BottomBarRoute(
        route = Route.CreditCards,
        icon = Icons.Default.CreditCard,
        title = Res.string.credit_cards
    )

    data object Profile : BottomBarRoute(
        route = Route.Profile,
        icon = Icons.Default.AccountCircle,
        title = Res.string.profile
    )
}
