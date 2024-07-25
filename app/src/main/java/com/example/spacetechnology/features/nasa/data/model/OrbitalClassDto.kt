package com.example.spacetechnology.features.nasa.data.model

import com.google.gson.annotations.SerializedName

data class OrbitalClassDto(
    @SerializedName("orbit_class_type") val orbitClassType: String,
    @SerializedName("orbit_class_description") val orbitClassDescription: String,
)
