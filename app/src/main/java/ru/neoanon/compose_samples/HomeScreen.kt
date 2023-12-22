package ru.neoanon.compose_samples

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TAG = "MY_TAG"

@Composable
fun HomeScreen() {
	Column {
		var checked by remember { mutableStateOf(true) }
		Checkbox(checked = checked, onCheckedChange = { checked = it })

		if (checked) {
			val scope = rememberCoroutineScope()
			Text(text = "Click", modifier = Modifier.clickable {
				scope.launch {
					var count = 0
					while (true) {
						Log.d(TAG, "count = ${count++}")
						delay(1000)
					}
				}
			})
		}
	}
}