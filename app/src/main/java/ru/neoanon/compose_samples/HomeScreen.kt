package ru.neoanon.compose_samples

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

const val TAG = "MY_TAG"

@Composable
fun HomeScreen(
	state: State<Int>,
	onCounterClick: () -> Unit
) {
	val counterValue = state.value
	Log.d(TAG, "HomeScreen")
	Column {
		clickCounter(counterValue, onCounterClick)
		val text = if (counterValue < 3) {
			"More"
		} else {
			"Enough"
		}
		InfoText(text)
	}
}

@Composable
fun clickCounter(
	counterValue: Int,
	onCounterClick: () -> Unit
) {
	Log.d(TAG, "clickCounter: $counterValue")
	Text(
		text = "Clicks: $counterValue",
		modifier = Modifier.clickable(onClick = onCounterClick)
	)
}

@Composable
fun InfoText(text: String) {
	Log.d(TAG, "InfoText $text")
	Text(text = text, fontSize = 24.sp)
}