package com.example.spacetechnology.features.my_posts.presentation.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.features.my_posts.presentation.ViewModelCreateMyPostScreen

@Composable
fun PostForMyPosts(
    viewModel: ViewModelCreateMyPostScreen
) {
    val statePosts by viewModel.myPosts.collectAsState()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(statePosts) { posts ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            SpaceTechColor.postsGradientDefault
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .border(
                        1.dp,
                        SpaceTechColor.navigationElement,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Log.d("TAG", "PostForMyPosts: ${posts.imageUri}")

                AsyncImage(
                    model = posts.imageUri.toUri().toString(),
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
                        text = posts.title,
                        fontWeight = FontWeight.SemiBold,
                        color = SpaceTechColor.white,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        textAlign = TextAlign.Center,
                        text = posts.description,
                        maxLines = 6,
                        overflow = TextOverflow.Ellipsis,
                        color = SpaceTechColor.white
                    )
                }
            }
        }
    }
}
