package com.example.spacetechnology.features.home.presentation.view

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.spacetechnology.R
import com.example.spacetechnology.features.home.domain.entity.SpacePostHome
import com.example.spacetechnology.features.my_posts.domain.entity.PostMyPosts

@Composable
fun CardsPreviewSpaceTech(
    postsSpacex: List<SpacePostHome>,
    postsNasa: List<SpacePostHome>,
    postMyPosts: List<PostMyPosts>

) {
    LazyRow {
        items(postsSpacex) {
            it.Post()
        }
    }
    LazyRow {
        items(postsNasa) {
            it.Post()
        }
    }
    if (postsSpacex.isNotEmpty()) {
        LazyRow {
            items(postMyPosts) {
                OneCardForMainScreen(
                    description = it.description,
                    imagePreview = it.imageUri,
                    compFun = {
                        CustomClickableIcon(pathIcon = R.drawable.space_tech_logo1, pathUrl = "")
                    },
                )
            }
        }
    }
}