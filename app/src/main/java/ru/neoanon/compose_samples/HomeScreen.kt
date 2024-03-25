package ru.neoanon.compose_samples

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontStyle
import kotlinx.coroutines.delay

const val TAG = "MY_TAG"
val LocalFontStyle = compositionLocalOf { FontStyle.Normal }

@Composable
fun HomeScreen() {
	val degrees by produceState(initialValue = 0f) {
		while (true) {
			delay(100)
			value = (value + 5f).rem(360)
		}
	}

	Spacer(modifier = Modifier
		.fillMaxSize()
		.graphicsLayer { rotationZ = degrees }
		.drawBehind {
			drawRect(
				brush = Brush.linearGradient(listOf(Color.Green, Color.Blue)),
				size = size.div(2f),
				topLeft = Offset(size.width / 4f, size.height / 4f)
			)
		}
	)
}