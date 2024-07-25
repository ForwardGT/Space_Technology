package com.example.spacetechnology.features.nasa.data.mapper

import com.example.spacetechnology.features.nasa.data.model.PostApodDto
import com.example.spacetechnology.features.nasa.domain.entity.PostApodNasa

fun mapperApodNasa(
    apod: PostApodDto
): PostApodNasa {
    val postApod = PostApodNasa(
        date = apod.date,
        urlImage = apod.urlImage,
        explanation = apod.explanation,
        title = apod.title
    )
    return postApod
}