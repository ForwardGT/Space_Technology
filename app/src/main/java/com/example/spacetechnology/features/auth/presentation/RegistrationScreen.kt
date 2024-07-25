package com.example.spacetechnology.features.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.core.utils.CustomSpacer
import com.example.spacetechnology.core.utils.LoadButton
import com.example.spacetechnology.features.auth.presentation.view.TextFieldCustom


@Composable
fun RegistrationScreen(
    navController: NavController
) {
    Scaffold { paddingValues ->
        Row(
            modifier = Modifier
                .padding(6.dp)
        ) {
            IconButton(
                modifier = Modifier.size(26.dp),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = SpaceTechColor.white
                )
            }
            CustomSpacer(h = 2.dp)
            Text(
                fontSize = 19.sp,
                text = "Back",
                color = SpaceTechColor.white
            )
        }
        MainContentRegistration(paddingValues)
    }
}

@Composable
private fun MainContentRegistration(
    paddingValues: PaddingValues
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
            visibilityIcon = false
        )

        TextFieldCustom(
            label = "Password",
            visibilityIcon = true
        )
        TextFieldCustom(
            label = "Repeat password",
            visibilityIcon = true
        )

        CustomSpacer(v = 20.dp)

        Row {
            LoadButton(
                onClick = { /*TODO*/ },
                defaultButton = true,
                label = "Exit"
            )
            CustomSpacer(h = 16.dp)
            LoadButton(
                onClick = { /*TODO*/ },
                defaultButton = true,
                label = "Login"
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