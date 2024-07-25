package com.example.spacetechnology.features.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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

@Composable
fun AuthScreen(
    navController: NavController
) {
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
            TextFieldCustom(label = "Email")
            TextFieldCustom(
                label = "Password",
                visibilityIcon = true
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
                    onClick = { /*TODO*/ },
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