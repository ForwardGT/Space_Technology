package com.example.spacetechnology.features.nasa.presentation

import com.example.spacetechnology.features.nasa.domain.entity.Asteroid
import com.example.spacetechnology.features.nasa.domain.entity.PostApodNasa
import com.example.spacetechnology.features.nasa.domain.entity.PostTechTransfer

data class NasaPostsState(
    val isLoadingPostAsteroids: Boolean =false,
    val isLoadingPostTechTransfer: Boolean =false,
    val isLoadingPostApod: Boolean =false,
    val postsAsteroids: Asteroid? = null,
    val postsTechTransfer: PostTechTransfer? = null,
    val postsApod: PostApodNasa? = null,
    val isError: Boolean = false,
)
