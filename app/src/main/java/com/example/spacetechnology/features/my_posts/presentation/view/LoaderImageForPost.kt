package com.example.spacetechnology.features.my_posts.presentation.view

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.view.CustomSpacer
import com.example.spacetechnology.features.my_posts.domain.entity.PostMyPosts
import com.example.spacetechnology.features.my_posts.domain.entity.TextFieldMyPostsError
import com.example.spacetechnology.features.my_posts.presentation.ViewModelCreateMyPostScreen

@Composable
fun LoaderImageForPost(
    viewModel: ViewModelCreateMyPostScreen,
    stateError: TextFieldMyPostsError,
    stateText: PostMyPosts
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Fill out the form",
            color = SpaceTechColor.white,
            fontSize = 26.sp,
            fontWeight = FontWeight.Medium
        )

        CustomSpacer(v = 4.dp)

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            ImageForPostMyPosts(
                viewModel = viewModel,
                stateText = stateText
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                fontSize = 14.sp,
                color = SpaceTechColor.red,
                textAlign = TextAlign.Center,
                text = stateError.imageError
            )
        }
    }
}


@Composable
private fun ImageForPostMyPosts(
    stateText: PostMyPosts,
    viewModel: ViewModelCreateMyPostScreen,
) {
    val photoPickLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                viewModel.addImageToPosts(it)
            }
        }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        if (stateText.imageUri.isNotBlank()) {
            AsyncImage(
                model = stateText.imageUri,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(150.dp)
                    .border(
                        width = 1.dp,
                        color = SpaceTechColor.navigationElement,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .clip(RoundedCornerShape(12.dp))
                    .clickable {
                        photoPickLauncher.launch(
                            PickVisualMediaRequest(
                                ActivityResultContracts.PickVisualMedia.ImageOnly
                            )
                        )
                    },
                contentScale = ContentScale.Crop
            )
        } else {
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(150.dp)
                    .border(
                        width = 1.dp,
                        color = SpaceTechColor.navigationElement,
                        shape = RoundedCornerShape(12.dp)
                    ),
                onClick = {
                    photoPickLauncher.launch(
                        PickVisualMediaRequest(
                            ActivityResultContracts.PickVisualMedia.ImageOnly
                        )
                    )
                }
            ) {
                Icon(
                    modifier = Modifier.size(150.dp),
                    imageVector = Icons.Filled.PhotoCamera,
                    contentDescription = null
                )
            }

        }
    }

}