package ru.neoanon.compose_samples

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.Easing
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TAG = "MY_TAG"
val LocalFontStyle = compositionLocalOf { FontStyle.Normal }

@Composable
fun HomeScreen() {
	val myAnimation = remember {
		Animatable(initialValue = 10.dp, typeConverter = Dp.VectorConverter)
	}

	Spacer(modifier = Modifier
		.background(Color.Green)
		.height(50.dp)
		.width(myAnimation.value)
	)

	LaunchedEffect(Unit) {
		delay(1000)
		myAnimation.animateTo(
			targetValue = 250.dp,
			animationSpec = createSpec()
		)
	}
}

val MyEasing: Easing = Easing { fraction ->
	when {
		fraction < 0.25 -> 0F
		fraction < 0.5 -> 0.25F
		fraction < 0.75 -> 0.5F
		fraction < 1 -> 0.75F
		else -> 1F
	}
}
private fun createSpec(): AnimationSpec<Dp> =
	tween(
		durationMillis = 1000,
		easing = MyEasing
	)