package ru.neoanon.compose_samples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle

const val TAG = "MY_TAG"
val LocalFontStyle = compositionLocalOf { FontStyle.Normal }

@Composable
fun HomeScreen() {
	Column {
		val italicState = remember { mutableStateOf(false) }
		MyCheckbox("Italic", italicState)

		val fontStyle = if (italicState.value) FontStyle.Italic else FontStyle.Normal
		CompositionLocalProvider(LocalFontStyle provides fontStyle) {
			MyText(text = "Text 1")
			MyText(text = "Text 2")
			MyText(text = "Text 3")
			MyText(text = "Text 4")
		}
		MyText(text = "Text 5")
	}
}

@Composable
fun MyCheckbox(
	text: String,
	checked: MutableState<Boolean>,
) {
	Row(verticalAlignment = Alignment.CenterVertically) {
		Checkbox(checked = checked.value, onCheckedChange = { checked.value = it })
		Text(text = text)
	}
}

@Composable
fun MyText(
	text: String
) {
	Text(text = text, fontStyle = LocalFontStyle.current)
}