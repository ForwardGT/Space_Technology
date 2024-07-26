package com.example.spacetechnology.features.auth.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spacetechnology.R
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.CustomSpacer
import com.example.spacetechnology.core.utils.LoadButton
import com.example.spacetechnology.navigation.Screen
import com.example.spacetechnology.navigation.navigateTo

@Composable
fun FirstAuthScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.first_auth_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            LoadButton(
                onClick = { navController.navigateTo(Screen.AuthScreen.route) },
                label = "Authorisation",
                defaultButton = true,
                gradient = SpaceTechColor.buttonGradientFirstAuthScreen
            )
            CustomSpacer(v = 4.dp)
            LoadButton(
                onClick = { navController.navigateTo(Screen.RegistrationScreen.route) },
                label = "Registration",
                defaultButton = true,
                gradient = SpaceTechColor.buttonGradientFirstAuthScreen
            )
        }
    }
}