package ru.neoanon.compose_samples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val state = mutableStateOf(HomeState(counterClick = 0, uppercase = false))
		setContent {
			HomeScreen(
				state,
				onCounterClick = {
					val currentState = state.value
					state.value = currentState.copy(counterClick = currentState.counterClick + 1)
				},
				onCheckedChange = { newUppercase ->
					val currentState = state.value
					state.value = currentState.copy(uppercase = newUppercase)
				},
			)
		}
	}
}