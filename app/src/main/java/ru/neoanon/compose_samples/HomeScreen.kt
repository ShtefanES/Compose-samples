package ru.neoanon.compose_samples

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Density

const val TAG = "MY_TAG"
val LocalFontStyle = compositionLocalOf { FontStyle.Normal }

@Composable
fun HomeScreen() {
	Timeline {
		Text("Task 1")
		Text("Task 2", modifier = Modifier.position(Position.PARALLEL))
		Text("Task 3")
		Text("Task 4")
		Text("Task 5", modifier = Modifier.position(Position.END))

		Text("Task 6")
		Text("Task 7", modifier = Modifier.position(Position.PARALLEL))
		Text("Task 8", modifier = Modifier.position(Position.PARALLEL))
		Text("Task 9")
		Text("Task 10")
	}
}

@Composable
fun Timeline(
	modifier: Modifier = Modifier, content: @Composable () -> Unit
) {
	Layout(
		modifier = modifier, content = content
	) { measurables, constraints ->
		val placeables = measurables.map { measurable ->
			measurable.measure(constraints) // Measure children
		}
		layout(constraints.maxWidth, constraints.maxHeight) { // Decide own size
			var x = 0
			var y = 0
			placeables.forEach { placeable ->
				val position = ((placeable as? Measurable)?.parentData as? PositionParentData)?.position
				placeable.placeRelative(x = x, y = y) // Place children
				when (position) {
					Position.PARALLEL -> {}

					Position.END      -> x = 0
					null              -> x += placeable.width
				}
				y += placeable.height
			}
		}
	}
}

class PositionParentData(
	val position: Position
) : ParentDataModifier {

	override fun Density.modifyParentData(parentData: Any?): Any? = this@PositionParentData
}

fun Modifier.position(position: Position) = this.then(PositionParentData(position))