package com.example.spacetechnology.features.my_posts.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.view.CustomButton
import com.example.spacetechnology.core.utils.view.CustomSpacer
import com.example.spacetechnology.core.utils.view.CustomTextField
import com.example.spacetechnology.features.auth.presentation.view.TopBarNavigation
import com.example.spacetechnology.features.my_posts.presentation.view.LoaderImageForPost
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateMyPostScreen(
    navController: NavController
) {
    Scaffold { paddingValues ->

        val viewModel: ViewModelCreateMyPostScreen = koinViewModel()
        val stateText by viewModel.stateTextField.collectAsState()
        val stateError by viewModel.errorTextField.collectAsState()

        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                TopBarNavigation(
                    titleScreen = "Create post",
                    routeNavigationBack = { navController.popBackStack() },
                )
                CustomSpacer(v = 4.dp)

                LoaderImageForPost(
                    viewModel = viewModel,
                    stateError = stateError,
                    stateText = stateText
                )

                CustomTextField(
                    value = stateText.title,
                    label = "Post title",
                    onValueChange = { viewModel.changeTitle(it) },
                    errorMessage = stateError.titleError
                )
                CustomTextField(
                    value = stateText.description,
                    label = "Description",
                    onValueChange = { viewModel.changeDescription(it) },
                    errorMessage = stateError.descriptionError
                )
            }

            CustomButton(
                onClick = {
                    viewModel.setPostsToMyPosts {
                        if (it) {
                            navController.popBackStack()
                        }
                    }
                },
                label = "Create post",
                defaultButton = true,
                fillMaxWidth = true,
                gradient = SpaceTechColor.buttonGradientCreate,
                padding = PaddingValues(start = 15.dp, end = 15.dp, bottom = 15.dp),
            )
        }
    }
}


