package com.example.spacetechnology.features.my_posts.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.spacetechnology.features.auth.presentation.view.TopBarNavigation

@Composable
fun MyPostsScreen(
    navController: NavController
) {
    Scaffold { paddingValues ->

        TopBarNavigation(
            titleScreen = "My posts",
            routeNavigationRightElement = { },
            needNavigationBack = false,
            needRightElement = true,
            titleRightText = "Create"
        )
        Box(modifier = Modifier.padding(paddingValues)) {

        }
    }
}