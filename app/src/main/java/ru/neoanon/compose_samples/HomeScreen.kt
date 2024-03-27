package ru.neoanon.compose_samples

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val TAG = "MY_TAG"
val LocalFontStyle = compositionLocalOf { FontStyle.Normal }

@Composable
fun HomeScreen() {
	val animation = remember {
		TargetBasedAnimation(
			animationSpec = tween(5000, easing = LinearEasing),
			typeConverter = Dp.VectorConverter,
			initialValue = 10.dp,
			targetValue = 300.dp
		)
	}

	val animationValueState = remember {
		mutableStateOf(10.dp)
	}

	Spacer(modifier = Modifier
		.background(Color.Green)
		.height(50.dp)
		.width(animationValueState.value)
	)

	LaunchedEffect(key1 = Unit) {
		val startTime = withFrameNanos { it }
		var playTime = 0L
		while(playTime <= animation.durationNanos) {
			playTime = withFrameNanos { it } - startTime
			animationValueState.value = animation.getValueFromNanos(playTime)
		}
	}
}