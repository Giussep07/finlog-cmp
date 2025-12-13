package dev.giussepr.finlog.core.presentation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home: Route
}