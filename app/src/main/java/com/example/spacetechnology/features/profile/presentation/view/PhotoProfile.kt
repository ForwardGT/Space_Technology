package com.example.spacetechnology.features.profile.presentation.view

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor


@Composable
fun PhotoProfile(
    stateImageProfile: Uri?,
    emailProfile: String,
    size: Dp = 128.dp
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        stateImageProfile?.let {
            AsyncImage(
                model = it,
                contentDescription = null,
                modifier = Modifier
                    .size(size)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        } ?: run {
            Icon(
                tint = SpaceTechColor.white,
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = null,
                modifier = Modifier
                    .size(size)
                    .clip(CircleShape)
            )
        }
        Text(
            textAlign = TextAlign.Center,
            color = SpaceTechColor.white,
            text = emailProfile,
        )
    }
}