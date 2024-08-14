package com.example.spacetechnology.features.my_posts.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.spacetechnology.core.utils.view.CustomButton
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
                    .fillMaxSize()
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

                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .height(170.dp)
                        .fillMaxWidth()
                ) {
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
                            maxLines = 5,
                            overflow = TextOverflow.Ellipsis,
                            color = SpaceTechColor.white
                        )
                    }
                    Box {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            text = posts.datePost,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = SpaceTechColor.gray
                        )
                    }
                }
            }
        }
        item {
            CustomButton(
                onClick = { viewModel.deleteAllPosts() },
                label = "Delete all posts",
                defaultButton = true,
                fillMaxWidth = true,
                gradient = SpaceTechColor.buttonGradientDanger,
                padding = PaddingValues(bottom = 10.dp)
            )
        }
    }
}
