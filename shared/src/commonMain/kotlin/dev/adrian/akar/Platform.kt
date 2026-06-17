package dev.adrian.akar

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform