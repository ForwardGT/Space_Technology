package com.example.spacetechnology.features.nasa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class OrbitalClassDto(
    val orbit_class_type: String,
    val orbit_class_description: String,
)
