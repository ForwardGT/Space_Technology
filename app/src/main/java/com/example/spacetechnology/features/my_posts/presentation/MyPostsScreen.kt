package com.example.spacetechnology.features.my_posts.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.R
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.core.utils.view.CustomSpacer
import com.example.spacetechnology.features.auth.presentation.view.TopBarNavigation

@Composable
fun MyPostsScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            SpaceTechNavigationBar(navController = navController)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 10.dp
                )
        ) {
            TopBarNavigation(
                titleScreen = "My posts",
                routeNavigationRightElement = { },
                needNavigationBack = false,
                needRightElement = true,
                titleRightText = "Create",
            )
            CustomSpacer(v = 6.dp)

            PostForMyPosts()
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

@Composable
fun PostForMyPosts() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    SpaceTechColor.postsGradientDefault
                ),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.rocket_preview),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(170.dp)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 8.dp,
                        bottomStart = 8.dp
                    )
                ),
        )
        Column {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Title"
            )
            Text(
                textAlign = TextAlign.Center,
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                maxLines = 6,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}