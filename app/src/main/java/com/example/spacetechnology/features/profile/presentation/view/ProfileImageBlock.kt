package com.example.spacetechnology.features.profile.presentation.view

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.spacetechnology.core.utils.CustomButton
import com.example.spacetechnology.core.utils.CustomSpacer
import com.example.spacetechnology.features.profile.presentation.ViewModelProfile

@Composable
fun ProfileImageBlock(
    viewModel: ViewModelProfile,
) {
    val stateImageProfile by viewModel.imageUri.collectAsState()
    val emailProfile by viewModel.userEmail.collectAsState()

    val photoPickLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                viewModel.saveImageToDevice(it)
            }
        }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        stateImageProfile?.let {
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