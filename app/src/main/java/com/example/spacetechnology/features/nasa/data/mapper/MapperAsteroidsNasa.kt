package com.example.spacetechnology.features.nasa.data.mapper

import com.example.spacetechnology.features.nasa.data.model.AsteroidsNearEarthObjectsDto
import com.example.spacetechnology.features.nasa.domain.entity.Asteroid

fun mapperAsteroidsNasa(
    request: AsteroidsNearEarthObjectsDto
): List<Asteroid> {
    val posts = mutableListOf<Asteroid>()

    request.asteroids.forEach {
        val post = Asteroid(
            name = it.name,
            url = it.url,
            absMagnitude = it.absMagnitude,
            estimatedDiameterMin = it.diameter.meters.estimatedDiameterMin,
            estimatedDiameterMax = it.diameter.meters.estimatedDiameterMin,
            orbitDeterminationDate = it.data.orbitDeterminationDate,
            firstObservationDate = it.data.firstObservationDate,
            orbitClassType = it.data.orbitClass.orbitClassType,
            orbitClassDescription = it.data.orbitClass.orbitClassDescription
        )
        posts.add(post)
    }

    return posts
}