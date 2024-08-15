package com.example.spacetechnology.features.spacex.data.mapper

import com.example.spacetechnology.features.spacex.data.model.RocketInformationDto
import com.example.spacetechnology.features.spacex.domain.entity.SpacexRocket

fun mapperSpacexRocket(
    response: List<RocketInformationDto>
): List<SpacexRocket> {
    val posts = mutableListOf<SpacexRocket>()

    response.forEach { item ->
        val post = SpacexRocket(
            name = item.name,
            diameter = item.diameter.meters,
            wikipedia = item.wikipedia,
            image = item.flickr_images,
            description = item.description,
            height = item.height.meters,
            firstFlight = item.first_flight,
            stages = item.stages,
            boosters = item.boosters
        )
        posts.add(post)
    }
    return posts
}