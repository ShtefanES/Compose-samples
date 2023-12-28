package ru.neoanon.compose_samples

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TAG = "MY_TAG"

@Composable
fun HomeScreen() {
	val count by produceState(initialValue = 0) {
		while (true) {
			delay(1000)
			value++
		}
	}

	Text(text = "count = $count")
}