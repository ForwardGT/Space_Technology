package com.example.spacetechnology.features.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.core.utils.CustomSpacer
import com.example.spacetechnology.core.utils.LoadButton
import com.example.spacetechnology.features.auth.presentation.view.AuthNavigationTopBar
import com.example.spacetechnology.features.auth.presentation.view.TextFieldCustom
import org.koin.androidx.compose.koinViewModel


@Composable
fun RegistrationScreen(
    navController: NavController
) {

    val viewModel: ViewModelRegistration = koinViewModel()

    Scaffold { paddingValues ->
        AuthNavigationTopBar(
            navController = navController,
            titleScreen = "Registration",
            paddingValues = paddingValues
        )
        MainContentRegistration(
            paddingValues = paddingValues,
            navController = navController,
            viewModel
        )
    }
}


@Composable
private fun MainContentRegistration(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: ViewModelRegistration
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        TextFieldCustom(
            label = "Email",
            isPassword = false,
            value = viewModel.email,
            onValueChange = { viewModel.email = it }
        )

        TextFieldCustom(
            label = "Password",
            isPassword = true,
            value = viewModel.password,
            onValueChange = { viewModel.password = it }
        )
        TextFieldCustom(
            label = "Repeat password",
            isPassword = true,
            value = viewModel.repeatPassword,
            onValueChange = { viewModel.repeatPassword = it }
        )

        CustomSpacer(v = 20.dp)

        Row {
            LoadButton(
                onClick = { navController.popBackStack() },
                defaultButton = true,
                label = "Exit"
            )
            CustomSpacer(h = 16.dp)
            LoadButton(
                onClick = { },
                defaultButton = true,
                label = "Registration",
            )
        }
    }
}

@Preview
@Composable
fun Q() {
    SpaceTechnologyTheme(darkTheme = true) {
        RegistrationScreen(navController = rememberNavController())
    }
}