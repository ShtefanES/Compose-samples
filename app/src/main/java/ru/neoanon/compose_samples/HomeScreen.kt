package ru.neoanon.compose_samples

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
	Text(
		text = "Home screen title",
		fontSize = 16.sp,
		color = Color.Green,
	)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
	HomeScreen()
}