package com.example.spacetechnology.features.home.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import com.example.spacetechnology.core.ui.theme.SpaceTechColor

@Composable
fun SpaceTechTopBar() {
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
                modifier = Modifier.size(width = 63.dp, height = 34.dp),
                painter = painterResource(id = R.drawable.space_tech_logo),
                contentDescription = "spaceX",
                contentScale = ContentScale.Crop
            )
        }
        Box {
            Text(
                color = SpaceTechColor.white,
                modifier = Modifier.padding(top = 12.dp, end = 10.dp),
                text = "Search"
            )
        }
    }
}