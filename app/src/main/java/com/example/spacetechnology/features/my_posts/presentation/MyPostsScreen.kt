package com.example.spacetechnology.features.my_posts.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.core.utils.extensions.navigation.navigateTo
import com.example.spacetechnology.core.utils.view.CustomSpacer
import com.example.spacetechnology.features.auth.presentation.view.TopBarNavigation
import com.example.spacetechnology.features.my_posts.presentation.view.PostForMyPosts
import com.example.spacetechnology.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MyPostsScreen(
    navController: NavController
) {
    val viewModel: ViewModelCreateMyPostScreen = koinViewModel()

    Scaffold(
        bottomBar = {
            SpaceTechNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 10.dp, end = 10.dp)
        ) {
            TopBarNavigation(
                titleScreen = "My posts",
                routeNavigationRightElement = { navController.navigateTo(Screen.CreateMyPostScreen.route) },
                needNavigationBack = false,
                needRightElement = true,
                titleRightText = "Create",
            )
            CustomSpacer(v = 3.dp)

            PostForMyPosts(viewModel)
        }
    }
}