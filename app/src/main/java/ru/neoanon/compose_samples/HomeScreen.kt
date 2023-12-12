package ru.neoanon.compose_samples

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi

const val TAG = "MY_TAG"

@Composable
fun HomeScreen(
	onNavigateToOrders: () -> Unit,
	onNavigateToUsers: () -> Unit,
) {
	Column() {
		Text(text = "Home screen")

		Text(text = "go to Orders", Modifier.clickable(onClick = onNavigateToOrders))

		Text(text = "go to Users", Modifier.clickable(onClick = onNavigateToUsers))
	}
}

@Composable
fun OrdersScreen() {
	Text(text = "Orders screen")
}

@Composable
fun UsersScreen() {
	Text(text = "Users screen")
}