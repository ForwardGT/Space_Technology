package com.example.spacetechnology.core.utils.validators

import com.example.spacetechnology.features.my_posts.domain.entity.TextFieldMyPostsError

fun validatorPostsFromMyPosts(
    title: String,
    description: String,
    image: String,
): TextFieldMyPostsError {
    val titleError = if (title.isBlank()) "Title can't be blank" else ""

    val descriptionError = if (description.isBlank()) "Description can't be blank" else ""

    val imageError = if (image.isBlank()) "Image can't be blank" else ""

    return TextFieldMyPostsError(titleError, descriptionError, imageError)
}