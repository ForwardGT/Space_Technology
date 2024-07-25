package com.example.spacetechnology.features.auth.presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor

@Composable
fun IconTextField(
    visibilityOn: Boolean = false,
    onClickVisibility: () -> Unit,
) {
    Icon(
        imageVector =
        if (visibilityOn) Icons.Default.Visibility
        else Icons.Default.VisibilityOff,
        contentDescription = null,
        tint = if (visibilityOn) SpaceTechColor.white else SpaceTechColor.gray,
        modifier = Modifier.clickable { onClickVisibility() }
    )
}