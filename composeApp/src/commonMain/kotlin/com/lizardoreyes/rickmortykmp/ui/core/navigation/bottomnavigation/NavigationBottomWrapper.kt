package com.lizardoreyes.rickmortykmp.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lizardoreyes.rickmortykmp.domain.model.CharacterModel
import com.lizardoreyes.rickmortykmp.ui.core.navigation.CharacterDetail
import com.lizardoreyes.rickmortykmp.ui.core.navigation.Routes
import com.lizardoreyes.rickmortykmp.ui.home.tabs.characters.CharactersScreen
import com.lizardoreyes.rickmortykmp.ui.home.tabs.episodes.EpisodesScreen
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun NavigationBottomWrapper(
    navigationController: NavHostController,
    mainNavController: NavHostController
) {
    NavHost(navController = navigationController, startDestination = Routes.Episodes.route) {
        composable(route = Routes.Episodes.route) {
            EpisodesScreen()
        }

        // Route with parameters
        composable(route = Routes.Characters.route) {
            CharactersScreen(
                navigateToDetail = { characterModel ->
                    val encode = Json.encodeToString(characterModel)
                    mainNavController.navigate(CharacterDetail(encode))
                }
            )
        }
    }
}