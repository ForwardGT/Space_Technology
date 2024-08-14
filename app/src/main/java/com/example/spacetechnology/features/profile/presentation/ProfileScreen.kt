package com.example.spacetechnology.features.profile.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.features.profile.domain.entity.DrawerNavigationItem
import com.example.spacetechnology.features.profile.presentation.view.PhotoProfile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@Composable
fun ProfileScreen(
    navController: NavController
) {
    val viewModel: ViewModelProfile = koinViewModel()

    val items = listOf(
        DrawerNavigationItem.Profile,
        DrawerNavigationItem.ApiKey,
        DrawerNavigationItem.About,
    )

    val stateImageProfile by viewModel.imageUri.collectAsState()
    val emailProfile by viewModel.userEmail.collectAsState()

    var selectedItem by remember { mutableStateOf(items[0].title) }
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
                    ModalDrawerSheet(
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            PhotoProfile(
                                stateImageProfile = stateImageProfile,
                                emailProfile = emailProfile,
                                size = 80.dp
                            )
                        }
                        items.forEach { item ->
                            ItemDrawer(
                                item = item,
                                scope = scope,
                                selectedItem = selectedItem,
                                drawerState = drawerState,
                                onItemSelected = { selectedItem = it }
                            )
                        }
                    }
                },
                content = {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Row {
                            IconButton(onClick = { scope.launch { drawerState.open() } },
                                content = { Icon(Icons.Filled.Menu, null) }
                            )
                        }

                        when (selectedItem) {

                            DrawerNavigationItem.Profile.title -> ProfileViewContent(
                                viewModel = viewModel,
                                navController = navController,
                                emailProfile = emailProfile,
                                stateImageProfile = stateImageProfile
                            )

                            DrawerNavigationItem.ApiKey.title -> ApiKeyViewContent()

                            DrawerNavigationItem.About.title -> AboutAppViewContent()
                        }
                    }
                }
            )
        }
    }
}

@Composable
private fun ItemDrawer(
    item: DrawerNavigationItem,
    scope: CoroutineScope,
    selectedItem: String,
    drawerState: DrawerState,
    onItemSelected: (String) -> Unit
) {
    NavigationDrawerItem(
        modifier = Modifier.padding(
            bottom = 4.dp,
            end = 4.dp,
            start = 4.dp
        ),
        shape = RoundedCornerShape(16.dp),
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = SpaceTechColor.navigationElement,
        ),
        label = {
            Text(
                color = SpaceTechColor.white,
                text = item.title, fontSize = 22.sp
            )
        },
        icon = {
            Icon(
                modifier = Modifier.size(23.dp),
                imageVector = item.iconItem,
                contentDescription = null,
                tint = SpaceTechColor.white
            )
        },
        selected = selectedItem == item.title,
        onClick = {
            scope.launch { drawerState.close() }
            onItemSelected(item.title)
        }
    )
}
