package com.example.spacetechnology.features.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.spacetechnology.navigation.Screen
import com.example.spacetechnology.navigation.navigateTo
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthScreen(
    navController: NavController
) {
    val viewModel: ViewModelRegistration = koinViewModel()
    val scope = rememberCoroutineScope()

    Scaffold { paddingValues ->

        AuthNavigationTopBar(
            navController = navController,
            titleScreen = "Authorisation",
            paddingValues = paddingValues
        )
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
            CustomSpacer(v = 20.dp)

            Row {
                LoadButton(
                    onClick = { /*TODO*/ },
                    label = "Exit",
                    defaultButton = true
                )
                CustomSpacer(h = 16.dp)
                LoadButton(
                    onClick = {
                        scope.launch {
                            viewModel.getUserData(
                                email = viewModel.email,
                                password = viewModel.password,
                                onResult = {
                                    if (it) {
                                        navController.navigateTo(Screen.HomeScreen.route)
                                    }
                                }
                            )
                        }
                    },
                    label = "Login",
                    defaultButton = true
                )
            }

        }
    }
}

@Preview
@Composable
fun Qqq() {
    SpaceTechnologyTheme(true) {
        AuthScreen(navController = rememberNavController())
    }
}