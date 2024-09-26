package com.lizardoreyes.rickmortykmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform