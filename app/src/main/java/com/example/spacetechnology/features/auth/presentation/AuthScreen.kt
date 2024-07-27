package com.example.spacetechnology.features.auth.presentation

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.core.utils.CustomSpacer
import com.example.spacetechnology.core.utils.LoadButton
import com.example.spacetechnology.core.utils.extensions.navigation.navigateTo
import com.example.spacetechnology.core.utils.extensions.navigation.navigateToClearBackStack
import com.example.spacetechnology.features.auth.presentation.view.AuthNavigationTopBar
import com.example.spacetechnology.features.auth.presentation.view.TextFieldCustom
import com.example.spacetechnology.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthScreen(
    navController: NavController
) {
    val viewModel: ViewModelAuth = koinViewModel()
    val state by viewModel.registrationState.collectAsState()

    Scaffold { paddingValues ->

        Log.d("TAG", "AuthScreen: ${state.errors}")
        Log.d("TAG", "AuthScreen: ${state.email}")
        Log.d("TAG", "AuthScreen: ${state.password}")

        AuthNavigationTopBar(
            route = { navController.navigateTo(Screen.FirstAuthScreen.route) },
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
                value = state.email,
                onValueChange = viewModel.setEmail,
                errorMessage = state.errors.emailError

            )
            TextFieldCustom(
                label = "Password",
                isPassword = true,
                value = state.password,
                onValueChange = viewModel.setPassword,
                errorMessage = state.errors.passwordError
            )
            CustomSpacer(v = 20.dp)

            Row {
                LoadButton(
                    onClick = { navController.navigateToClearBackStack(Screen.FirstAuthScreen.route) },
                    label = "Exit",
                    defaultButton = true
                )
                CustomSpacer(h = 16.dp)
                LoadButton(
                    onClick = {
                        viewModel.getUserData(
                            onResult = {
                                if (it) { navController.navigateTo(Screen.HomeScreen.route) }
                            }
                        )
                    },
                    label = "Login",
                    defaultButton = true
                )
            }
        }
    }
    BackHandler {
        viewModel.clearState()
        navController.popBackStack()
    }
}

@Preview
@Composable
fun Qqq() {
    SpaceTechnologyTheme(true) {
        AuthScreen(navController = rememberNavController())
    }
}