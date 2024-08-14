package com.example.spacetechnology.features.nasa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AsteroidsDto(
    val name_limited: String,
    val nasa_jpl_url: String,
    val absolute_magnitude_h: Float,
    val estimated_diameter: EstimatedDiameterDto,
    val orbital_data: OrbitalData,
)