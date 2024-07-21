package com.example.spacetechnology.features.home.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.utils.openLinkInBrowser
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.features.home.presentation.HomeScreen

@Composable
fun ClickableIcon(
    pathIcon: Int,
    pathUrl: String
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        IconButton(
            modifier = Modifier.size(width = 100.dp, height = 50.dp),
            onClick = {
                openLinkInBrowser(context, pathUrl)
            }
        ) {
            Image(
                painter = painterResource(id = pathIcon),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
private fun p() {
    SpaceTechnologyTheme(darkTheme = true) {
        HomeScreen(navController = rememberNavController())
    }
}