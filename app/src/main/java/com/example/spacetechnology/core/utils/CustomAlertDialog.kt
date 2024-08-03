package com.example.spacetechnology.core.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor

@Composable
fun CustomAlertDialog(
    onClickConfirm: () -> Unit,
    onClickDismiss: () -> Unit,
    onClickDismissRequest: () -> Unit,
) {
    AlertDialog(
        icon = {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = null
            )
        },
        containerColor = SpaceTechColor.backgroundText,
        titleContentColor = SpaceTechColor.white,
        iconContentColor = SpaceTechColor.white,
        textContentColor = SpaceTechColor.white,
        title = { Text("Confirmation") },
        text = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Are you sure you want to do this?"
            )
        },
        onDismissRequest = { onClickDismissRequest() },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CustomButton(
                    onClick = { onClickConfirm() },
                    label = "Yes",
                    defaultButton = true,
                    height = 36.dp,
                    width = 110.dp
                )
                CustomButton(
                    onClick = { onClickDismiss() },
                    label = "No",
                    defaultButton = true,
                    height = 36.dp,
                    width = 110.dp
                )
            }
        }
    )
}