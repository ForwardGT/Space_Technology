package com.example.spacetechnology.features.nasa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PostApodDto(
    val date: String,
    val url: String,
    val explanation: String,
    val title: String,
)