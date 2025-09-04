package com.maciejweglarz.rickandmortyapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.maciejweglarz.rickandmortyapp.details.presentation.CharacterDetails
import com.maciejweglarz.rickandmortyapp.details.presentation.CharacterDetailsViewModel
import com.maciejweglarz.rickandmortyapp.list.presentation.CharacterListViewModel
import com.maciejweglarz.rickandmortyapp.list.presentation.CharactersListScreen

@Composable
fun RickAndMortyNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavDestinations.CharactersList.route
    ) {
        composable(NavDestinations.CharactersList.route) {
            val viewModel: CharacterListViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            CharactersListScreen(
                state = state,
                navController = navController
            )
        }
        composable(
            NavDestinations.CharactersDetails.route,
            arguments = listOf(
                navArgument("characterId") { type = NavType.IntType }
            )
        ) {
            navBackStackEntry ->
            val characterId = remember {
                navBackStackEntry.arguments?.getInt("characterId")
            }
            val viewModel: CharacterDetailsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()

            CharacterDetails(
                navController = navController,
                state = state
            )

        }
    }
}