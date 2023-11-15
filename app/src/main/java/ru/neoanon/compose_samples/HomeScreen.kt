package ru.neoanon.compose_samples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(state: State<Boolean>, onCheckedChange: (Boolean) -> Unit) {
	Row(verticalAlignment = CenterVertically) {
		Checkbox(checked = state.value, onCheckedChange = onCheckedChange)
		Text("Some checkbox text", fontSize = 32.sp, modifier = Modifier.clickable {
			val currentValue = state.value
			onCheckedChange(!currentValue)
		})
	}
}