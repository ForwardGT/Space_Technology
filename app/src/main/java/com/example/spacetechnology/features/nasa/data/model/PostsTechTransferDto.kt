package com.example.spacetechnology.features.nasa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PostsTechTransferDto(
    val results: List<List<String>>
)