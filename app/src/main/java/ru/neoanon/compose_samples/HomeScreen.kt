package ru.neoanon.compose_samples

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

const val TAG = "MY_TAG"
val LocalFontStyle = compositionLocalOf { FontStyle.Normal }

@Composable
fun HomeScreen() {
	val animatable = remember {
		Animatable(initialValue = 10.dp, typeConverter = Dp.VectorConverter)
	}

	Column {
		Row {
			val scope = rememberCoroutineScope()
			MyTargetButton(animatable, targetValue = 10.dp, duration = 5000)
			Spacer(modifier = Modifier.width(16.dp))
			MyTargetButton(animatable, targetValue = 300.dp, duration = 1000)
		}
		Spacer(
			modifier = Modifier
				.background(Color.Green)
				.height(50.dp)
				.width(animatable.value)
		)
	}
}

@Composable
private fun MyTargetButton(animatable: Animatable<Dp, AnimationVector1D>, targetValue: Dp, duration: Int) {
	val scope = rememberCoroutineScope()
	Button(onClick = {
		scope.launch {
			val animationResult = animatable.animateTo(targetValue, tween(duration, easing = LinearEasing)) {
				Log.d(TAG, "velocity = $velocity")
			}
			Log.d(TAG, "end reason = ${animationResult.endReason}")
		}
	}) {
		Text(text = targetValue.toString())
	}
}