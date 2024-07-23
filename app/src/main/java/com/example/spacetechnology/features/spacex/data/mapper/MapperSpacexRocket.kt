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
            diameter = item.diameter.meter,
            wikipedia = item.wikipedia,
            image = item.image,
            description = item.description,
            height = item.height.meter,
            firstFlight = item.firstFlight,
            stages = item.stages,
            boosters = item.boosters
        )
        posts.add(post)
    }
    return posts
}