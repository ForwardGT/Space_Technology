package com.example.spacetechnology.core.utils.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CustomToast(
    message: String,
    isVisible: Boolean,
    durationMillis: Int = 2000,
    onDismiss: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val animatedOffsetY by animateDpAsState(
        targetValue = if (isVisible) 0.dp else 100.dp,
        animationSpec = tween(durationMillis = 500),
        label = ""
    )

    LaunchedEffect(isVisible) {
        if (isVisible) {
            coroutineScope.launch {
                delay(durationMillis.toLong()) // Automatically dismiss the toast after the specified duration
                onDismiss()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .offset(y = animatedOffsetY)
            .wrapContentHeight()
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(tween(durationMillis = 500)),
            exit = fadeOut(tween(durationMillis = 500))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(SpaceTechColor.navigationElement, shape = RoundedCornerShape(10.dp))
                    .padding(12.dp)
            ) {
                Text(
                    text = message,
                    color = SpaceTechColor.white,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
