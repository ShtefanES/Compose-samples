package ru.neoanon.compose_samples

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun HomeScreen() {
	Box(contentAlignment = Center, modifier = Modifier.fillMaxSize()) {
		Box(
			contentAlignment = Center,
			modifier = Modifier
				.width(160.dp)
				.height(140.dp)
				.border(
					width = 2.dp,
					shape = RoundedCornerShape(8.dp),
					brush = Brush.linearGradient(colors = listOf(Color.Yellow, Color.Blue, Color.Green)),
				)
		) {
			//Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null)
			AsyncImage(
				model = "https://developer.android.com/images/android-go/next-billion-users_856.png",
				contentDescription = null
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
	HomeScreen()
}