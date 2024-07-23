package com.example.spacetechnology.features.spacex.data.mapper

import com.example.spacetechnology.features.spacex.data.model.DragonInformationDto
import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon

fun mapperSpacexDragon(
    response: List<DragonInformationDto>
): List<SpacexDragon> {
    val posts = mutableListOf<SpacexDragon>()

    response.forEach { item ->
        val post = SpacexDragon(
            name = item.name,
            type = item.type,
            crewCapacity = item.crewCapacity,
            diameter = item.diameter.meters,
            dryMassKg = item.dryMassKg,
            wikipedia = item.wikipedia,
            image = item.image,
            description = item.description,
            launchPayloadMass = item.launchPayloadMass.kg
        )
        posts.add(post)
    }
    return posts
}