package com.lizardoreyes.rickmortykmp.ui.core.navigation

import kotlinx.serialization.Serializable

sealed class Routes(val route: String) {
    data object Home : Routes("home")

    // BottomNav
    data object Episodes : Routes("episodes")
    data object Characters : Routes("characters")
}

// If the route has parameters, we can create a data class to hold them
// Fecha: 05/10/2024
@Serializable
data class CharacterDetail(val characterModel: String)