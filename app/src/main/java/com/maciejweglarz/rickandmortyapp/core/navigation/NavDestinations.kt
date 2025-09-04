package com.maciejweglarz.rickandmortyapp.core.navigation

sealed class NavDestinations(val route: String) {
    data object CharactersList : NavDestinations("characters_list")
    data object CharactersDetails : NavDestinations("characters_details/{characterId}") {
        fun createRoute(characterId: Int) = "characters_details/$characterId"
    }
}