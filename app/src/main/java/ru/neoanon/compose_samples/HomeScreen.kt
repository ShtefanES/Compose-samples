package ru.neoanon.compose_samples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

const val TAG = "MY_TAG"

@Composable
fun HomeScreen() {
	var checked by remember { mutableStateOf(false) }
	Column {
		Row(verticalAlignment = CenterVertically) {
			Checkbox(checked = checked, onCheckedChange = { value -> checked = value })
			Text("More details", fontSize = 18.sp)
		}
		if (checked) {
			Text(text = stringResource(id = R.string.details))
		}
	}
}