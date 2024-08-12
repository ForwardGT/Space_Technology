package com.example.spacetechnology.features.auth.presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.core.utils.extensions.thenIf
import com.example.spacetechnology.core.utils.view.CustomSpacer
import com.example.spacetechnology.features.my_posts.presentation.MyPostsScreen

@Composable
fun TopBarNavigation(
    routeNavigationBack: () -> Unit = {},
    routeNavigationRightElement: () -> Unit = {},
    titleScreen: String,
    titleRightText: String = "",
    needRightElement: Boolean = false,
    needNavigationBack: Boolean = true,
    systemBarsPadding: Boolean = false,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .thenIf(systemBarsPadding, Modifier.systemBarsPadding()),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row{

            if (needNavigationBack) {
                IconButton(
                    modifier = Modifier.size(26.dp),
                    onClick = { routeNavigationBack() },
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = SpaceTechColor.white
                    )
                }
                CustomSpacer(h = 1.dp)
            }
            Text(
                fontSize = 19.sp,
                text = titleScreen,
                color = SpaceTechColor.white
            )
        }

        if (needRightElement) {
            Box {
                Text(
                    modifier = Modifier.clickable {
                        routeNavigationRightElement()
                    },
                    fontSize = 19.sp,
                    text = titleRightText,
                    color = SpaceTechColor.white
                )
            }
        }
    }
}

@Preview
@Composable
private fun Q() {
    SpaceTechnologyTheme(true) {
        MyPostsScreen(navController = rememberNavController())
    }
}
