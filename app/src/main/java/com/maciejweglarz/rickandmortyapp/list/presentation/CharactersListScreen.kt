package com.maciejweglarz.rickandmortyapp.list.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.maciejweglarz.rickandmortyapp.R
import com.maciejweglarz.rickandmortyapp.core.composables.FullScreenError
import com.maciejweglarz.rickandmortyapp.core.composables.LoadingProgressBar
import com.maciejweglarz.rickandmortyapp.core.navigation.NavDestinations
import com.maciejweglarz.rickandmortyapp.core.utils.ViewState
import com.maciejweglarz.rickandmortyapp.list.presentation.components.CharacterListItem

@Composable
fun CharactersListScreen(
    navController: NavController,
    state: CharacterListViewState
) {
    Scaffold { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding)
        ) {
            when (state.charactersListViewState) {
                is ViewState.Error -> { FullScreenError(modifier = Modifier, message = stringResource(R.string.loading_error_message)) }
                is ViewState.Loading -> { LoadingProgressBar(modifier = Modifier.fillMaxSize()) }
                is ViewState.Content -> {
                    state.charactersListViewState.data?.let { characterInfo ->
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            itemsIndexed(characterInfo) { index, item ->
                                CharacterListItem(
                                    id = item.id,
                                    name = item.name,
                                    image = item.image,
                                    episodes = item.numberOfEpisodes.toString(),
                                    onItemClicked = {
                                        navController.navigate(
                                            route = NavDestinations.CharactersDetails.createRoute(item.id)
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun CharactersListScreenPreview() {
//    CharactersListScreen(
//        state = CharacterListViewState().copy(
//            charactersListViewState = ViewState.Content(
//                listOf(
//                    CharacterInfo(
//                        id = 1,
//                        name = "Rick Sanchez",
//                        image = "",
//                        numberOfEpisodes = 51
//                    ),
//                    CharacterInfo(2, "Morty Smith", "", 51),
//                    CharacterInfo(3, "Summer Smith", "", 45),
//                    CharacterInfo(4, "Beth Smith", "", 40),
//                    CharacterInfo(5, "Jerry Smith", "", 38)
//                )
//            )
//        )
//    )
//}