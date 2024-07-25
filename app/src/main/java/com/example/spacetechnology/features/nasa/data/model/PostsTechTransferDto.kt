package com.example.spacetechnology.features.nasa.data.model

import com.google.gson.annotations.SerializedName

data class PostsTechTransferDto(
    @SerializedName("results") val posts: List<List<String>>
)