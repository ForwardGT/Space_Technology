package com.example.spacetechnology.features.my_posts.domain.entity

import android.net.Uri

data class PostMyPostsState(
    val title: String = "",
    val description: String = "",
    val imageUri: Uri? = null
)
