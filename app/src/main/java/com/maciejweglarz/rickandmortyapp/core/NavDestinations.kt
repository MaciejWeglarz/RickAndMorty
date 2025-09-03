package com.maciejweglarz.rickandmortyapp.core

sealed class NavDestinations(val route: String) {
    data object CharactersList : NavDestinations("characters_list")
    data object CharactersDetails : NavDestinations("characters_details")
}