package com.example.spacetechnology.features.spacex.data.mapper

import com.example.spacetechnology.features.spacex.data.model.DragonInformationDto
import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon

fun List<DragonInformationDto>.mapperSpacexDragon(): List<SpacexDragon> {
    val posts = mutableListOf<SpacexDragon>()

    this.forEach { item ->
        val post = SpacexDragon(
            name = item.name,
            type = item.type,
            crewCapacity = item.crew_capacity,
            diameter = item.diameter.meters,
            dryMassKg = item.dry_mass_kg,
            wikipedia = item.wikipedia,
            image = item.flickr_images,
            description = item.description,
            launchPayloadMass = item.launch_payload_mass.kg
        )
        posts.add(post)
    }
    return posts
}