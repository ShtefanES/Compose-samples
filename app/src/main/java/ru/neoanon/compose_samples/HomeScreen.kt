package ru.neoanon.compose_samples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

const val TAG = "MY_TAG"
val LocalFontStyle = compositionLocalOf { FontStyle.Normal }

@Composable
fun HomeScreen() {
	Scaffold(
		topBar = {
			TopAppBar {
				Text("Top bar")
			}
		},
		bottomBar = {
			BottomAppBar {
				Text("Bottom bar")
			}
		},
		floatingActionButton = {
			FloatingActionButton(onClick = {  }) {
				Icon(
					imageVector = Icons.Filled.Add,
					contentDescription = null
				)
			}
		},
		drawerContent = {
			Text("Drawer item 1", modifier = Modifier.padding(8.dp))
			Text("Drawer item 2", modifier = Modifier.padding(8.dp))
			Text("Drawer item 3", modifier = Modifier.padding(8.dp))
		},
		content = {paddingValues ->
			Box(
				modifier = Modifier.fillMaxSize().padding(paddingValues),
				contentAlignment = Alignment.Center
			) {
				Text("Content")
			}
		}
	)
}