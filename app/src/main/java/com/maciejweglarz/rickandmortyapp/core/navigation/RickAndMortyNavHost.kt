package com.maciejweglarz.rickandmortyapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maciejweglarz.rickandmortyapp.core.NavDestinations

@Composable
fun RickAndMortyNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavDestinations.CharactersList.route
    ) {
        composable(NavDestinations.CharactersList.route) {

        }
        composable(NavDestinations.CharactersDetails.route) {

        }
    }
}