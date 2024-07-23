package com.example.spacetechnology.core.utils


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.extensions.thenIf

@Composable
fun CirProgIndicator(
    needHeightScreen: Boolean = false
) {

    val viewWidth = with(LocalDensity.current) {
        (LocalView.current.rootView.height.toDp())
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .thenIf(
                condition = needHeightScreen,
                modifier = Modifier.height(viewWidth)
            )
            .background(SpaceTechColor.background),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}