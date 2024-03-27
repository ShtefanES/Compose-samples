package ru.neoanon.compose_samples

import androidx.compose.animation.core.AnimationSpec
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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

const val TAG = "MY_TAG"
val LocalFontStyle = compositionLocalOf { FontStyle.Normal }

@Composable
fun HomeScreen() {
	val myAnimation = remember {
		MyAnimation()
	}

	Column {
		Row {
			val scope = rememberCoroutineScope()
			MyTargetButton(myAnimation, targetValue = 10.dp, duration = 5000)
			Spacer(modifier = Modifier.width(16.dp))
			MyTargetButton(myAnimation, targetValue = 300.dp, duration = 1000)
		}
		Spacer(modifier = Modifier
			.background(Color.Green)
			.height(50.dp)
			.width(myAnimation.animationValueState.value)
		)
	}
}

@Composable
private fun MyTargetButton(myAnimation: MyAnimation, targetValue: Dp, duration: Int) {
	val scope = rememberCoroutineScope()
	Button(onClick = { scope.launch {
		myAnimation.animateTo(targetValue, tween(duration, easing = LinearEasing))
	}}) {
		Text(text = targetValue.toString())
	}
}
class MyAnimation {

	private val mutatorMutex = androidx.compose.foundation.MutatorMutex()

	val animationValueState = mutableStateOf(10.dp)

	suspend fun animateTo(targetValue: Dp, animationSpec: AnimationSpec<Dp>) {
		val animation = TargetBasedAnimation(
			animationSpec = animationSpec,
			typeConverter = Dp.VectorConverter,
			initialValue = animationValueState.value,
			targetValue = targetValue,
		)

		mutatorMutex.mutate {
			val startTime = withFrameNanos { it }
			var playTime = 0L
			while (playTime <= animation.durationNanos) {
				playTime = withFrameNanos { it } - startTime
				animationValueState.value = animation.getValueFromNanos(playTime)
			}
		}
	}
}