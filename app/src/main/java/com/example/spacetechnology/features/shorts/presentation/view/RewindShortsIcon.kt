package com.example.spacetechnology.features.shorts.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacetechnology.R

@Composable
fun RewindShortsIcon() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            painter = painterResource(R.drawable.rewind), null,
            modifier = Modifier
                .size(100.dp),
            tint = Color(0xffabc8c7)
        )
        Text(
            textAlign = TextAlign.Center,
            text = "X4 Speed",
            color = Color(0xffabc8c7),
            fontSize = 30.sp
        )
    }
}