package com.maciejweglarz.rickandmortyapp.core.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maciejweglarz.rickandmortyapp.R

@Composable
fun LoadingProgressBar(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun FullScreenError(
    modifier: Modifier,
    message: String
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.Warning,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.error
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = message,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}



@Preview
@Composable
fun LoadingProgressBarPreview() {
    LoadingProgressBar()
}

@Preview
@Composable
fun FullScreenErrorPreview() {
    FullScreenError(
        modifier = Modifier,
        message = stringResource(R.string.loading_error_message)
    )
}