package com.example.spacetechnology.features.profile.presentation

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.CustomAlertDialog
import com.example.spacetechnology.core.utils.CustomButton
import com.example.spacetechnology.core.utils.CustomSpacer
import com.example.spacetechnology.core.utils.extensions.navigation.navigateToClearBackStack
import com.example.spacetechnology.features.nasa.data.network.apiKeyNasa
import com.example.spacetechnology.features.profile.domain.entity.DrawerNavigationItem
import com.example.spacetechnology.features.profile.presentation.view.AboutAppViewContent
import com.example.spacetechnology.navigation.Screen
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
                    ModalDrawerSheet {
                        Box(
                            Modifier
                                .size(30.dp)
                                .background(Color.Red)
                        ) {

                        }
                        items.forEach { item ->
                            NavigationDrawerItem(
                                label = { Text(item.title, fontSize = 22.sp) },
                                selected = selectedItem == item.title,
                                onClick = {
                                    scope.launch { drawerState.close() }
                                    selectedItem = item.title
                                }
                            )
                        }
                    }
                },
                content = {
                    Column(Modifier.fillMaxSize()) {
                        Box {
                            IconButton(onClick = { scope.launch { drawerState.open() } },
                                content = { Icon(Icons.Filled.Menu, null) }
                            )
                        }

                        when (selectedItem) {
                            DrawerNavigationItem.Profile.title -> ProfileView(
                                viewModel,
                                navController
                            )

                            DrawerNavigationItem.ApiKey.title -> ApikeyView()
                            DrawerNavigationItem.About.title -> AboutAppViewContent()
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
private fun ProfileView(
    viewModel: ViewModelProfile,
    navController: NavController
) {
    val stateUri by viewModel.imageUri.collectAsState()
    val emailProfile by viewModel.userEmail.collectAsState()

    val photoPickLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                viewModel.saveImageToDevice(it)
            }
        }

    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            stateUri?.let {
                AsyncImage(
                    model = it,
                    contentDescription = null,
                    modifier = Modifier
                        .size(128.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            } ?: run {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier
                        .size(128.dp)
                        .clip(CircleShape)
                )
            }

            Text(text = emailProfile)

            CustomButton(
                onClick = { photoPickLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) },
                label = "Update photo",
                defaultButton = true,
                height = 40.dp,
                width = 130.dp
            )
            CustomSpacer(v = 5.dp)
            CustomButton(
                onClick = { viewModel.clearPhotoImagePath() },
                label = "Delete photo",
                defaultButton = true,
                height = 40.dp,
                width = 130.dp
            )
        }

        if (showDialog) {
            CustomAlertDialog(
                onClickConfirm = {
                    showDialog = false
                    viewModel.clearPhotoImagePath()
                    viewModel.deleteProfile()
                    navController.navigateToClearBackStack(Screen.FirstAuthScreen.route)
                },
                onClickDismiss = { showDialog = false },
                onClickDismissRequest = { showDialog = false }
            )
        }

        Box {

            CustomButton(
                onClick = { showDialog = true },
                label = "Delete profile",
                defaultButton = true,
                fillMaxWidth = true,
                gradient = SpaceTechColor.buttonGradientDanger
            )
        }
    }
}

@Composable
fun Profile() {

}