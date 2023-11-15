package ru.neoanon.compose_samples

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

@Composable
fun HomeScreen(state: State<String>, onValueChange: (String) -> Unit) {
	OutlinedTextField(value = state.value, onValueChange = onValueChange)
}