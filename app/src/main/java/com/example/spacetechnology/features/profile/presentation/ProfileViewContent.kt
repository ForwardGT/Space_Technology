package com.example.spacetechnology.features.profile.presentation

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.extensions.navigation.navigateToClearBackStack
import com.example.spacetechnology.core.utils.view.CustomAlertDialog
import com.example.spacetechnology.core.utils.view.CustomButton
import com.example.spacetechnology.core.utils.view.CustomSpacer
import com.example.spacetechnology.features.profile.presentation.view.PhotoProfile
import com.example.spacetechnology.navigation.Screen

@Composable
fun ProfileViewContent(
    viewModel: ViewModelProfile,
    navController: NavController,
    emailProfile: String,
    stateImageProfile: Uri?
) {
    var showDialogDeleteProfile by remember { mutableStateOf(false) }
    var showDialogClearCache by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,

    ) {

        ProfileImageBlock(
            viewModel = viewModel,
            emailProfile = emailProfile,
            stateImageProfile = stateImageProfile
        )

        if (showDialogDeleteProfile) {
            CustomAlertDialog(
                onClickConfirm = {
                    showDialogDeleteProfile = false
                    viewModel.clearPhotoImagePath()
                    viewModel.deleteProfile()
                    navController.navigateToClearBackStack(Screen.FirstAuthScreen.route)
                },
                onClickDismiss = { showDialogDeleteProfile = false },
                onClickDismissRequest = { showDialogDeleteProfile = false }
            )
        }

        if (showDialogDeleteProfile) {
            CustomAlertDialog(
                onClickConfirm = {
                    showDialogDeleteProfile = false
                },
                onClickDismiss = { showDialogDeleteProfile = false },
                onClickDismissRequest = { showDialogDeleteProfile = false }
            )
        }

        Column {

            CustomButton(
                onClick = { showDialogClearCache = true },
                label = "Clear cache",
                defaultButton = true,
                fillMaxWidth = true,
                gradient = SpaceTechColor.buttonGradientDanger,
                padding = PaddingValues(start = 10.dp, end = 10.dp, bottom = 10.dp),
            )

            CustomButton(
                onClick = { showDialogDeleteProfile = true },
                label = "Delete profile",
                defaultButton = true,
                fillMaxWidth = true,
                gradient = SpaceTechColor.buttonGradientDanger,
                padding = PaddingValues(start = 10.dp, end = 10.dp, bottom = 10.dp),
            )
        }
    }
}

@Composable
private fun ProfileImageBlock(
    viewModel: ViewModelProfile,
    emailProfile: String,
    stateImageProfile: Uri?
) {
    val photoPickLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                viewModel.clearPhotoImagePath()
                viewModel.saveImageToDevice(it)
            }
        }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        PhotoProfile(
            emailProfile = emailProfile,
            stateImageProfile = stateImageProfile
        )

        CustomSpacer(v = 2.dp)

        CustomButton(
            onClick = { photoPickLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) },
            label = "Update photo",
            defaultButton = true,
            height = 40.dp,
            width = 130.dp
        )

        CustomSpacer(v = 4.dp)

        CustomButton(
            onClick = { viewModel.clearPhotoImagePath() },
            label = "Delete photo",
            defaultButton = true,
            height = 40.dp,
            width = 130.dp
        )
    }
}