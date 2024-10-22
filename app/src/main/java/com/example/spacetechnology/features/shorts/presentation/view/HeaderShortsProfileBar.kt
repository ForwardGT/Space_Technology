package com.example.spacetechnology.features.shorts.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacetechnology.R

@Composable
fun HeaderShortsProfileBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(R.drawable.avatar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(50.dp)
                .clip(CircleShape),
        )
        Column(
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Row {
                Text(
                    fontSize = 18.sp,
                    text = "Elon Reeve Musk",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.padding(start = 8.dp))

                Text(
                    fontSize = 18.sp,
                    text = "2h.",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }
            Text(
                text = "Space X",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W300
            )
        }
    }
}
