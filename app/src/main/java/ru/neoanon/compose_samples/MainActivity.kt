package ru.neoanon.compose_samples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi

class MainActivity : ComponentActivity() {

	@OptIn(ExperimentalLifecycleComposeApi::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			HomeScreen()
		}
	}
}