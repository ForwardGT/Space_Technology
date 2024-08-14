package com.example.spacetechnology.features.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spacetechnology.core.utils.extensions.navigation.navigateTo
import com.example.spacetechnology.core.utils.view.CustomButton
import com.example.spacetechnology.core.utils.view.CustomSpacer
import com.example.spacetechnology.core.utils.view.CustomTextFieldAuth
import com.example.spacetechnology.features.auth.presentation.view.TopBarNavigation
import com.example.spacetechnology.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@Composable
fun RegistrationScreen(
    navController: NavController
) {
    val viewModel: ViewModelAuth = koinViewModel()
    val state by viewModel.authState.collectAsState()

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            TopBarNavigation(
                routeNavigationBack = { navController.navigateTo(Screen.FirstAuthScreen.route) },
                titleScreen = "Registration",
            )
            MainContentRegistration(
                navController = navController,
                viewModel = viewModel,
                state = state
            )
        }
    }
}


@Composable
private fun MainContentRegistration(
    navController: NavController,
    viewModel: ViewModelAuth,
    state: AuthState

) {
    val scope = rememberCoroutineScope()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
    ) {
        CustomTextFieldAuth(
            state = state,
            label = "Email",
            isPassword = false,
            value = state.email,
            onValueChange = { viewModel.setEmail(it) },
            errorMessage = state.errors.emailError
        )

        CustomTextFieldAuth(
            state = state,
            label = "Password",
            isPassword = true,
            value = state.password,
            onValueChange = { viewModel.setPassword(it) },
            errorMessage = state.errors.passwordError
        )

        CustomTextFieldAuth(
            state = state,
            label = "Repeat password",
            isPassword = true,
            value = state.repeatPassword,
            onValueChange = { viewModel.setRepeatPassword(it) },
            errorMessage = state.errors.repeatPasswordError
        )

        CustomSpacer(v = 10.dp)

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
        ) {
            CustomButton(
                onClick = navController::popBackStack,
                defaultButton = true,
                label = "Exit",
            )
            CustomButton(
                onClick = {
                    viewModel.setUserData {
                        if (it) {
                            scope.launch {
                                delay(800) // From imitation load
                                navController.navigateTo(Screen.AuthScreen.route)
                            }
                        }
                    }
                },
                defaultButton = true,
                label = "Registration",
            )
        }
    }
}