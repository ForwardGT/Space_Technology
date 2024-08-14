package com.example.spacetechnology.features.nasa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AsteroidsNearEarthObjectsDto(
    val near_earth_objects: List<AsteroidsDto>
)
