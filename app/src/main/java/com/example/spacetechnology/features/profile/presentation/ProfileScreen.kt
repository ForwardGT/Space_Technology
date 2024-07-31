package com.example.spacetechnology.features.profile.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.features.nasa.data.network.apiKeyNasa
import com.example.spacetechnology.features.profile.presentation.view.AboutAppViewContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController
) {
    val items = listOf("Profile", "Api key", "About")
    var selectedItem by remember { mutableStateOf(items[0]) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            SpaceTechNavigationBar(navController)
        }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {


            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    ModalDrawerSheet {
                        Box(
                            Modifier
                                .size(30.dp)
                                .background(Color.Red)
                        ) {

                        }
                        items.forEach { item ->
                            NavigationDrawerItem(
                                label = { Text(item, fontSize = 22.sp) },
                                selected = selectedItem == item,
                                onClick = {
                                    scope.launch { drawerState.close() }
                                    selectedItem = item
                                }
                            )
                        }
                    }
                },
                content = {
                    Column (Modifier.fillMaxSize()) {
                        Box {
                            IconButton(onClick = { scope.launch { drawerState.open() } },
                                content = { Icon(Icons.Filled.Menu, null) }
                            )
                        }

                        when (selectedItem) {
                            "Profile" -> ProfileView()
                            "Api key" -> ApikeyView()
                            "About" -> AboutAppViewContent()
                        }
                    }
                }
            )
        }
    }
}

@Composable
private fun ApikeyView() {
    Column(

        modifier = Modifier
    ) {
        Text(text = "Api key = $apiKeyNasa")
    }
}

@Composable
private fun ProfileView() {
    Column(
        modifier = Modifier

    ) {
        Text(text = "Hello")
    }
}



@Preview
@Composable
private fun T() {
    SpaceTechnologyTheme(true) {
        ProfileScreen(navController = rememberNavController())
    }
}