package com.lizardoreyes.rickmortykmp.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lizardoreyes.rickmortykmp.ui.core.navigation.Routes
import com.lizardoreyes.rickmortykmp.ui.home.tabs.characters.CharactersScreen
import com.lizardoreyes.rickmortykmp.ui.home.tabs.episodes.EpisodesScreen

@Composable
fun NavigationBottomWrapper(navigationController: NavHostController) {
    NavHost(navController = navigationController, startDestination = Routes.Episodes.route) {
        composable(route = Routes.Episodes.route) {
            EpisodesScreen()
        }

        composable(route = Routes.Characters.route) {
            CharactersScreen()
        }
    }
}