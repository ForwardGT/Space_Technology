package com.example.spacetechnology.features.auth.presentation.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.features.auth.presentation.RegistrationScreen

@Composable
fun TextFieldCustom(
    label: String,
    visibilityIcon: Boolean = false,
) {

    var value by remember {
        mutableStateOf("")
    }
    var visibility by remember {
        mutableStateOf(false)
    }

    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text(text = label) },
        visualTransformation =
        if (!visibility && visibilityIcon) PasswordVisualTransformation()
        else VisualTransformation.None,
        singleLine = true,
        supportingText = { Text(text = "Hello") },
        trailingIcon = {
            when {
                visibilityIcon && visibility -> {
                    IconTextField(visibilityOn = true) { visibility = !visibility }
                }

                visibilityIcon && !visibility -> {
                    IconTextField { visibility = !visibility }
                }
            }

        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        colors = TextFieldDefaults.colors(
            cursorColor = SpaceTechColor.white,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedContainerColor = SpaceTechColor.navigationElement,
            focusedTextColor = SpaceTechColor.white, //TODO от сюда берет цвет подчеркивания падла
            unfocusedTextColor = SpaceTechColor.gray,
            disabledTextColor = SpaceTechColor.gray,
            unfocusedSupportingTextColor = SpaceTechColor.red,
            focusedSupportingTextColor = SpaceTechColor.red,
            disabledSupportingTextColor = Color.Red,
            unfocusedLabelColor = SpaceTechColor.white,
            focusedLabelColor = SpaceTechColor.gray,
        )
    )
}

@Preview
@Composable
fun Q() {
    SpaceTechnologyTheme(darkTheme = true) {
        RegistrationScreen(navController = rememberNavController())
    }

}