package com.example.spacetechnology.features.profile.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.CustomAlertDialog
import com.example.spacetechnology.core.utils.CustomButton
import com.example.spacetechnology.core.utils.extensions.navigation.navigateToClearBackStack
import com.example.spacetechnology.features.profile.presentation.view.ProfileImageBlock
import com.example.spacetechnology.navigation.Screen

@Composable
fun ProfileViewContent(
    viewModel: ViewModelProfile,
    navController: NavController
) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        ProfileImageBlock(viewModel)

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
