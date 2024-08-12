package com.example.spacetechnology.core.utils.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor

@Composable
fun CustomTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    errorMessage: String,
) {
    TextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = value,
        onValueChange = onValueChange,
        label = { Text( text = label) },
        singleLine = true,
        supportingText = { Text(text = errorMessage) },
        trailingIcon = {

        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        colors = SpaceTechColor.textFieldColors()
    )
}