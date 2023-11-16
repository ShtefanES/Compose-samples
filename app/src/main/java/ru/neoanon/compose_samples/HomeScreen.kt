package ru.neoanon.compose_samples

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import okhttp3.internal.toHexString

const val TAG = "MY_TAG"

@Composable
fun HomeScreen(
	state: State<HomeState>,
	onCounterClick: () -> Unit,
	onCheckedChange: (Boolean) -> Unit,
) {
	val homeState = state.value
	Log.d(TAG, "HomeScreen")
	Column {
		ClickCounter(homeState.counterClick, homeState.uppercase, onCounterClick)
		Row(verticalAlignment = Alignment.CenterVertically) {
			Checkbox(checked = homeState.uppercase, onCheckedChange = onCheckedChange)
			Text("Uppercase", fontSize = 32.sp, modifier = Modifier.clickable {
				val currentCheckedValue = state.value.uppercase
				onCheckedChange(!currentCheckedValue)
			})
		}
	}
}

@Composable
fun ClickCounter(
	counterValue: Int,
	uppercase: Boolean,
	onCounterClick: () -> Unit
) {
	val evenOdd = remember(uppercase) { EvenOdd(uppercase) }
	Log.d(TAG, "ClickCounter(counter = $counterValue, uppercase = $uppercase), $evenOdd")
	Text(
		text = "Clicks: $counterValue - ${evenOdd.check(counterValue)}",
		modifier = Modifier.clickable(onClick = onCounterClick),
		fontSize = 32.sp,
	)
}

class EvenOdd(private val uppercase: Boolean) {

	fun check(value: Int): String {
		var result = if (value % 2 == 0) "even" else "odd"
		if (uppercase) result = result.uppercase()
		return result
	}

	override fun toString(): String {
		return "EvenOdd(uppercase = $uppercase, hashcode = ${hashCode().toHexString()})"
	}
}

data class HomeState(val counterClick: Int, val uppercase: Boolean)