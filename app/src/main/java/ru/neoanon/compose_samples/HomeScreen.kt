package ru.neoanon.compose_samples

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Checkbox
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

const val TAG = "MY_TAG"

@Composable
fun HomeScreen(
) {
	Column {
		val sliderPosition = remember { mutableStateOf(1f) }
		MySlider(sliderPosition = sliderPosition)

		val roundedPosition by remember {
			derivedStateOf { sliderPosition.value.roundToInt() }
		}
		Text(text = "$roundedPosition")
		Log.d(TAG, "HomeScreen $roundedPosition")
	}
}

@Composable
fun MySlider(sliderPosition: MutableState<Float>) {
	Log.d(TAG, "MySlider")
	Slider(
		value = sliderPosition.value,
		valueRange = 1f..10f,
		onValueChange = { sliderPosition.value = it }
	)
}