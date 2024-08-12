package com.example.spacetechnology.features.my_posts.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class PostMyPosts(
    val title: String = "",
    val description: String = "",
    val imageUri: String = ""
)
