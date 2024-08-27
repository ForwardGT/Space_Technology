package com.example.spacetechnology.features.nasa.data.mapper

import com.example.spacetechnology.features.nasa.data.model.AsteroidsNearEarthObjectsDto
import com.example.spacetechnology.features.nasa.domain.entity.Asteroid

fun AsteroidsNearEarthObjectsDto.mapperAsteroidsNasa(): List<Asteroid> {
    val posts = mutableListOf<Asteroid>()

    this.near_earth_objects.forEach {
        val post = Asteroid(
            name = it.name_limited,
            url = it.nasa_jpl_url,
            absMagnitude = it.absolute_magnitude_h,
            estimatedDiameterMin = it.estimated_diameter.meters.estimated_diameter_min,
            estimatedDiameterMax = it.estimated_diameter.meters.estimated_diameter_max,
            orbitDeterminationDate = it.orbital_data.orbit_determination_date,
            firstObservationDate = it.orbital_data.first_observation_date,
            orbitClassType = it.orbital_data.orbit_class.orbit_class_type,
            orbitClassDescription = it.orbital_data.orbit_class.orbit_class_description
        )
        posts.add(post)
    }

    return posts
}