package com.example.spacetechnology.core.utils.view


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.features.auth.presentation.AuthState
import com.example.spacetechnology.features.auth.presentation.view.IconTextField
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun CustomTextField(
    value: String,
    label: String,
    isPassword: Boolean = false,
    onValueChange: (String) -> Unit,
    errorMessage: String,
    state: AuthState
) {

    var visibilityIcon by remember {
        mutableStateOf(false)
}

    var showCheckIcon by remember { mutableStateOf(false) }

    LaunchedEffect(state.registrationSuccess, state.loginSuccess) {
        if (state.registrationSuccess || state.loginSuccess) {
            delay(Random.nextLong(400L, 800L)) // From imitation load
            showCheckIcon = true
        } else {
            showCheckIcon = false
        }
    }

    TextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = value,
        onValueChange = onValueChange,
        label = { Text( text = label) },
        visualTransformation =
        if (!visibilityIcon && isPassword) PasswordVisualTransformation()
        else VisualTransformation.None,
        singleLine = true,
        supportingText = { Text(text = errorMessage) },
        trailingIcon = {
            when {
                showCheckIcon -> {
                    Icon(
                        imageVector = Icons.Default.CheckCircle, contentDescription = null,
                        tint = SpaceTechColor.green,
                    )
                }

                isPassword && visibilityIcon -> {
                    IconTextField(visibilityOn = true) { visibilityIcon = !visibilityIcon }
                }

                isPassword && !visibilityIcon -> {
                    IconTextField { visibilityIcon = !visibilityIcon }
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
            focusedTextColor = SpaceTechColor.white,
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