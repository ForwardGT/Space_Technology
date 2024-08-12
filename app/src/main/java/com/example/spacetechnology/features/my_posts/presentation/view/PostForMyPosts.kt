package com.example.spacetechnology.features.my_posts.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.spacetechnology.R
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor

@Composable
fun PostForMyPosts() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    SpaceTechColor.postsGradientDefault
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .border(1.dp, SpaceTechColor.navigationElement, shape = RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.rocket_preview),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(170.dp)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        bottomStart = 10.dp
                    )
                ),
        )
        Column {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Title",
                fontWeight = FontWeight.SemiBold,
                color = SpaceTechColor.white
            )
            Text(
                textAlign = TextAlign.Center,
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                maxLines = 6,
                overflow = TextOverflow.Ellipsis,
                color = SpaceTechColor.white
            )
        }
    }
}