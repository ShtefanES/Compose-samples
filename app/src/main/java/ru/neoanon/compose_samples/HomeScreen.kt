package ru.neoanon.compose_samples

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

const val TAG = "MY_TAG"
val LocalFontStyle = compositionLocalOf { FontStyle.Normal }

@Composable
fun HomeScreen() {
	Box(
		modifier = Modifier.background(Color.LightGray)
	) {
		Text(text = "Some text", modifier = Modifier.myLayout())
	}
}

fun Modifier.myLayout() = layout { measurable, constraints ->
	Log.d(TAG, "constraints = $constraints")
	val placeable = measurable.measure(constraints) // Measure children
	Log.d(TAG, "placeable, width = ${placeable.width}, height = ${placeable.height} ")
	layout(placeable.width, placeable.height) { // Decide own size
		placeable.placeRelative(0, 0) // Place children
	}
}