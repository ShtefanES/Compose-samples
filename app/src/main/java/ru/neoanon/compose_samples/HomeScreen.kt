package ru.neoanon.compose_samples

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.text.font.FontStyle

const val TAG = "MY_TAG"
val LocalFontStyle = compositionLocalOf { FontStyle.Normal }

@Composable
fun HomeScreen() {
	Canvas(modifier = Modifier.fillMaxSize()) {
		withTransform({
						  translate( - center.x + 100f, - center.y + 100f)
						  rotate(degrees = 45f)
					  }) {
			cross()
		}
	}
}

private fun DrawScope.cross() {
	drawLine(
		color = Color.Green,
		start = center.plus(Offset(-50f,-50f)),
		end = center.plus(Offset(50f,50f)),
		strokeWidth = 5f
	)
	drawLine(
		color = Color.Green,
		start = center.plus(Offset(50f,-50f)),
		end = center.plus(Offset(-50f,50f)),
		strokeWidth = 5f
	)
}