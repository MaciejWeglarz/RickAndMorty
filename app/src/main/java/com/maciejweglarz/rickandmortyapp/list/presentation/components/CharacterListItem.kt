package com.maciejweglarz.rickandmortyapp.list.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.maciejweglarz.rickandmortyapp.details.presentation.SpacerSmall

@Composable
fun CharacterListItem(
    id: Int,
    name: String,
    image: String,
    episodes: String,
    onItemClicked: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClicked(id) }
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(16.dp)),
                model = image,
                contentDescription = null
            )
            SpacerSmall()
            Text(
                text = name
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "Number of episodes: $episodes"
            )

        }
    }
}

@Preview
@Composable
fun CharacterCardPreview() {
    CharacterListItem(
        id = 1,
        name = "Rick Sanchez",
        image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
        episodes = "51",
        onItemClicked = { }
    )
}