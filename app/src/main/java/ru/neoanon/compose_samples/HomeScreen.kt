package ru.neoanon.compose_samples

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(state: State<Int>, onCounterClick: () -> Unit) {
	Text(text = "Clicks: ${state.value}", modifier = Modifier.clickable(onClick = onCounterClick))
}