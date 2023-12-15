package ru.neoanon.compose_samples

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import okhttp3.internal.toHexString

const val TAG = "MY_TAG"

@Composable
fun HomeScreen() {
	Column {
		var checked by remember { mutableStateOf(false) }
		Checkbox(checked = checked, onCheckedChange = { checked = it })
		if (checked) {
			val myObject = remember { MyObject() }
		}
	}
}

@Composable
fun ClickCounter() {
	var count by remember { mutableStateOf(0) }
	Text(
		text = "Count $count",
		modifier = Modifier.clickable { count++ }
	)
}

class MyObject : RememberObserver {

	init {
		Log.d(TAG, "init")
	}

	override fun onRemembered() {
		Log.d(TAG, "onRemembered")
	}

	override fun onForgotten() {
		Log.d(TAG, "onForgotten")
	}

	override fun onAbandoned() {
		Log.d(TAG, "onAbandoned")
	}

}