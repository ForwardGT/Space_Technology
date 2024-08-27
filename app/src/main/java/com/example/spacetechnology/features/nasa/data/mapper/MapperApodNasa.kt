package com.example.spacetechnology.features.nasa.data.mapper

import com.example.spacetechnology.features.nasa.data.model.PostApodDto
import com.example.spacetechnology.features.nasa.domain.entity.PostApodNasa

fun PostApodDto.mapperApodNasa(): PostApodNasa {
    val postApod = PostApodNasa(
        date = this.date,
        urlImage = this.url,
        description = this.explanation,
        title = this.title
    )
    return postApod
}