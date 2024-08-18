package com.example.spacetechnology.features.home.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.spacetechnology.R
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
@Composable
fun SpaceTechMainScreenTopBar() {
    Row(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier.padding(start = 6.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(42.dp)
                    .aspectRatio(0.7f),
                painter = painterResource(id = R.drawable.space_tech_logo1),
                contentDescription = "spaceX",
                contentScale = ContentScale.FillHeight
            )
        }
        Box {
            Text(
                color = SpaceTechColor.white,
                modifier = Modifier.padding(top = 12.dp, end = 10.dp),
                text = ""
            )
        }
    }
}
