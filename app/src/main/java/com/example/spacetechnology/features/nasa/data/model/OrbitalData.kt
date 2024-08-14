package com.example.spacetechnology.features.nasa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class OrbitalData(
    val orbit_determination_date: String,
    val first_observation_date: String,
    val orbit_class: OrbitalClassDto
)