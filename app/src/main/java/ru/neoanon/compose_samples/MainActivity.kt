package ru.neoanon.compose_samples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			Column {
				var route by remember { mutableStateOf("home") }
				Box(modifier = Modifier.weight(1f).padding(16.dp)) {
					when (route) {
						"home" -> HomeScreen(
							onNavigateToOrders = {route = "orders"},
							onNavigateToUsers = {route = "users"},
						)

						"orders" -> OrdersScreen()

						"users" -> UsersScreen()
					}
				}
				Row(
					modifier = Modifier.fillMaxWidth().padding(16.dp),
					horizontalArrangement = Arrangement.SpaceEvenly
				) {
					Text(text = "Home", modifier = Modifier.clickable { route = "home"})
					Text(text = "Orders", modifier = Modifier.clickable { route = "orders" })
					Text(text = "Users", modifier = Modifier.clickable { route = "users" })
				}
			}
		}
	}
}