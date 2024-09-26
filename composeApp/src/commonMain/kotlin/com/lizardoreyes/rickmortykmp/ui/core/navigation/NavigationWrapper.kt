package com.lizardoreyes.rickmortykmp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lizardoreyes.rickmortykmp.ui.home.HomeScreen

@Composable
fun NavigationWrapper() {
    val mainNavController = rememberNavController()

    NavHost(navController = mainNavController, startDestination = Routes.Home.route) {
        // List of routes the app can navigate
        composable(route = Routes.Home.route) {
            HomeScreen()
        }
    }
}