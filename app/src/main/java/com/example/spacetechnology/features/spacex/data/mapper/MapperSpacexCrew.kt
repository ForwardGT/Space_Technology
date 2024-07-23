package com.example.spacetechnology.features.spacex.data.mapper

import com.example.spacetechnology.features.spacex.data.model.LandPadsInformationDto
import com.example.spacetechnology.features.spacex.domain.entity.SpacexLandPads

fun mapperSpacexLandPads(
    response: List<LandPadsInformationDto>
): List<SpacexLandPads> {
    val posts = mutableListOf<SpacexLandPads>()

    response.forEach { item ->
        val post = SpacexLandPads(
            name = item.name,
            wikipedia = item.wikipedia,
            image = item.images.large,
            status = item.status,
            description = item.description,
            landingSuccesses = item.landingSuccesses,
            landingAttempts = item.landingAttempts,
            region = item.region,
            latitude = item.latitude,
            type = item.type,
            longitude = item.longitude,
        )
        posts.add(post)
    }
    return posts
}