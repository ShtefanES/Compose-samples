package ru.neoanon.compose_samples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

const val TAG = "MY_TAG"

@ExperimentalLifecycleComposeApi
@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {

	val state by viewModel.state.collectAsStateWithLifecycle()

	Column {
		ClickCounter(count = state.clickCounter, viewModel::increaseCounter)
		EnableFeature(enabled = state.enabledFeature, onEnabledChange = viewModel::changeEnabled)
	}
}

@Composable
fun ClickCounter(
	count: Int,
	onCounterClick: () -> Unit
) {
	Text(
		text = "Clicks: $count",
		modifier = Modifier.clickable(onClick = onCounterClick)
	)
}

@Composable
fun EnableFeature(
	enabled: Boolean,
	onEnabledChange: (Boolean) -> Unit
) {
	Row(verticalAlignment = CenterVertically) {
		Checkbox(checked = enabled, onCheckedChange = onEnabledChange)
		Text("enable feature")
	}
}