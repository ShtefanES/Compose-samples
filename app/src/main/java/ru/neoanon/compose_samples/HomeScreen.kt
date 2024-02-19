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
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

const val TAG = "MY_TAG"
val LocalFontStyle = compositionLocalOf { FontStyle.Normal }

@Composable
fun HomeScreen() {
	MyColumn(modifier = Modifier.background(Color.Gray)) {
		Text("Text 1")
		Text("Text 2")
		Text("Text 3")
		Text("Text 4")
	}
}

@Composable
fun MyColumn(
	modifier: Modifier = Modifier,
	content: @Composable () -> Unit
) {
	Layout(
		modifier = modifier,
		content = content
	) { measurables, constraints ->
		val placeables = measurables.map {measurable ->
			measurable.measure(constraints) // Measure children
		}
		layout(placeables.maxOf { it.width }, placeables.sumOf { it.height }) { // Decide own size
			var y = 0
			placeables.forEach { placeable ->
				placeable.placeRelative(x = 0, y = y) // Place children
				y += placeable.height
			}
		}
	}
}