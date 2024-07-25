package com.example.spacetechnology.features.auth.presentation.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.CustomSpacer

@Composable
fun AuthNavigationTopBar(
    navController: NavController,
    titleScreen: String,
    paddingValues: PaddingValues
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues)
    ) {
        IconButton(
            modifier = Modifier.size(26.dp),
            onClick = { navController.popBackStack() },
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = SpaceTechColor.white
            )
        }
        CustomSpacer(h = 1.dp)
        Text(
            fontSize = 19.sp,
            text = "Back $titleScreen",
            color = SpaceTechColor.white
        )
    }
}