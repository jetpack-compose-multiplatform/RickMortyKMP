package com.lizardoreyes.rickmortykmp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import com.lizardoreyes.rickmortykmp.ui.detail.CharacterDetailScreen
import com.lizardoreyes.rickmortykmp.ui.home.HomeScreen
import kotlinx.serialization.json.Json

@Composable
fun NavigationWrapper() {
    val mainNavController = rememberNavController()

    NavHost(navController = mainNavController, startDestination = Routes.Home.route) {
        // List of routes the app can navigate
        composable(route = Routes.Home.route) {
            HomeScreen(mainNavController)
        }

        // Screen with parameters
        composable<CharacterDetail> {
            val characterDetailEncoding = it.toRoute<CharacterDetail>()
            val characterModel = Json.decodeFromString<CharacterModel>(characterDetailEncoding.characterModel)
            CharacterDetailScreen(characterModel)
        }
    }
}