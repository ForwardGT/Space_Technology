package com.example.spacetechnology.features.my_posts.presentation

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.view.CustomSpacer
import com.example.spacetechnology.core.utils.view.CustomTextField
import com.example.spacetechnology.features.auth.presentation.view.TopBarNavigation
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateMyPostScreen(
    navController: NavController
) {
    Scaffold { paddingValues ->

        val viewModel: ViewModelCreateMyPostScreen = koinViewModel()
        val stateText by viewModel.stateTextField.collectAsState()

        Column(
            Modifier.padding(paddingValues)
        ) {
            TopBarNavigation(
                titleScreen = "Create post",
                routeNavigationRightElement = { navController.popBackStack() },
            )
            Column {
                LoadImageForPost(viewModel)

                CustomSpacer(v = 6.dp)

                CustomTextField(
                    value = stateText.title,
                    label = "Post title",
                    onValueChange = { viewModel.changeTitle(it) },
                    errorMessage = "qwerty"
                )
                CustomTextField(
                    value = stateText.description,
                    label = "Description",
                    onValueChange = { viewModel.changeDescription(it) },
                    errorMessage = "qwerty"
                )

            }
        }
    }
}


@Composable
private fun LoadImageForPost(
    viewModel: ViewModelCreateMyPostScreen
) {

    var stateText by remember {
        mutableStateOf("")
    }

    val photoPickLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                viewModel.saveImage(it)
            }
        }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Please load image",
            color = SpaceTechColor.white,
            fontSize = 26.sp,
            fontWeight = FontWeight.Medium
        )

        CustomSpacer(v = 4.dp)

        IconButton(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .size(150.dp)
                .border(
                    width = 1.dp,
                    color = SpaceTechColor.navigationElement,
                    shape = RoundedCornerShape(12.dp)
                ),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                modifier = Modifier.size(150.dp),
                imageVector = Icons.Filled.PhotoCamera,
                contentDescription = null
            )
        }
    }
}