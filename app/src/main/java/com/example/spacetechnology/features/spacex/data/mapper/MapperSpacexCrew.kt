package com.example.spacetechnology.features.spacex.data.mapper

import com.example.spacetechnology.features.spacex.data.model.LandPadsInformationDto
import com.example.spacetechnology.features.spacex.domain.entity.SpacexLandPads

fun List<LandPadsInformationDto>.mapperSpacexLandPads(): List<SpacexLandPads> {
    val posts = mutableListOf<SpacexLandPads>()

    this.forEach { item ->
        val post = SpacexLandPads(
            name = item.name,
            wikipedia = item.wikipedia,
            image = item.images.large,
            status = item.status,
            description = item.details,
            landingSuccesses = item.landing_successes,
            landingAttempts = item.landing_attempts,
            region = item.region,
            latitude = item.latitude,
            type = item.type,
            longitude = item.longitude,
        )
        posts.add(post)
    }
    return posts
}