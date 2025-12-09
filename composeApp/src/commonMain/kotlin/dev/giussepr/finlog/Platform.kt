package dev.giussepr.finlog

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform