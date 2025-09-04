package com.maciejweglarz.rickandmortyapp.details.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.maciejweglarz.rickandmortyapp.R
import com.maciejweglarz.rickandmortyapp.core.composables.LoadingProgressBar
import com.maciejweglarz.rickandmortyapp.core.utils.ViewState

@Composable
fun CharacterDetails(
    navController: NavController,
    state: CharacterDetailsViewState
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.characterDetailsViewState) {
        if (state.characterDetailsViewState is ViewState.Error) {
            val result = snackbarHostState.showSnackbar(message = "Ups coś poszło nie tak", actionLabel = "OK", duration = SnackbarDuration.Indefinite)
            when (result) {
                SnackbarResult.Dismissed -> {
                    navController.popBackStack()
                }
                SnackbarResult.ActionPerformed -> {
                    navController.popBackStack()
                }
            }
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) { contentPadding ->
        Card(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding()
            ) {
                when (state.characterDetailsViewState) {
                    is ViewState.Error -> {
                    }
                    is ViewState.Loading -> {
                        LoadingProgressBar(modifier = Modifier.fillMaxSize())
                    }
                    is ViewState.Content -> {
                        state.characterDetailsViewState.data?.let { characterDetails ->
                            with(characterDetails) {
                                Column(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxSize()
                                ) {
                                    AsyncImage(
                                        model = image,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .align(Alignment.CenterHorizontally)
                                            .clip(RoundedCornerShape(16.dp))
                                            .size(200.dp)
                                    )
                                    Text(
                                        modifier = Modifier.padding(top = 16.dp),
                                        text = stringResource(R.string.character_details_name_label, name)
                                    )
                                    SpacerSmall()
                                    Text(
                                        text = stringResource(R.string.character_details_status_label, status)
                                    )
                                    if (type.isNotEmpty()) {
                                        SpacerSmall()
                                        Text(
                                            text = stringResource(R.string.character_details_species_label, type)
                                        )
                                    }
                                    SpacerSmall()
                                    Text(
                                        text = stringResource(R.string.character_details_sex_label, sex)
                                    )
                                    SpacerSmall()
                                    Text(
                                        text = stringResource(R.string.character_details_origin_label, origin)
                                    )
                                    SpacerSmall()
                                    Text(
                                        text = stringResource(R.string.character_details_created_label, created)
                                    )
                                    SpacerSmall()
                                    Text(
                                        text = stringResource(R.string.character_details_episodes_label, numberOfEpisodes.size)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
    @Composable
    fun SpacerSmall() {
        Spacer(modifier = Modifier.padding(4.dp))
    }
