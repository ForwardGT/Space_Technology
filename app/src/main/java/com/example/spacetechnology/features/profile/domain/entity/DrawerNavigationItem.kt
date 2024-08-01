package com.example.spacetechnology.features.profile.domain.entity

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ContentPaste
import androidx.compose.material.icons.filled.Key
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerNavigationItem(
    val title : String,
    val iconItem : ImageVector,
) {
    data object Profile : DrawerNavigationItem(
        iconItem = Icons.Filled.AccountCircle,
        title = "Profile"
    )
    data object ApiKey : DrawerNavigationItem(
        iconItem = Icons.Filled.Key,
        title = "Api key"
    )
    data object About : DrawerNavigationItem(
        iconItem = Icons.Filled.ContentPaste,
        title = "About"
    )
}