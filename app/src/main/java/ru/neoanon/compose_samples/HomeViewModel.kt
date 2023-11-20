package ru.neoanon.compose_samples

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

	private val _state = MutableStateFlow(HomeState(clickCounter = 0, enabledFeature = false))
	val state: StateFlow<HomeState> = _state

	fun increaseCounter() {
		val currentState = _state.value
		_state.value = currentState.copy(clickCounter = currentState.clickCounter + 1)
	}

	fun changeEnabled(enabled: Boolean) {
		val currentState = _state.value
		_state.value = currentState.copy(enabledFeature = enabled)
	}
}