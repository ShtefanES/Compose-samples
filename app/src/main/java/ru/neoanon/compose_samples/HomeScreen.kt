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
		Text(text = "Some text", modifier = Modifier
			.background(Color.Yellow)
			.myPadding(1)
			.background(Color.Red)
			.myPadding(2)
			.background(Color.Blue)
			.myPadding(3)
			.background(Color.Green)
		)
	}
}

fun Modifier.myPadding(id: Int) = layout { measurable, constraints ->
	Log.d(TAG, "myPadding $id, measure child")
	val placeable = measurable.measure(constraints)

	val myWidth = placeable.width + 50
	val myHeight = placeable.height + 50
	Log.d(TAG, "myPadding $id, child: (${placeable.width}, ${placeable.height}), me: ($myWidth, $myHeight)")

	layout(myWidth, myHeight) {
		placeable.placeRelative(25, 25)
	}
}