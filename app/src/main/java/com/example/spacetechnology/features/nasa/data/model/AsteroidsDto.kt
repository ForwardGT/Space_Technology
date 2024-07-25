package com.example.spacetechnology.features.nasa.data.model

import com.google.gson.annotations.SerializedName

data class AsteroidsDto(
    @SerializedName("name_limited") val name: String,
    @SerializedName("nasa_jpl_url") val url: String,
    @SerializedName("absolute_magnitude_h") val absMagnitude: Float,
    @SerializedName("estimated_diameter") val diameter: EstimatedDiameterDto,
    @SerializedName("orbital_data") val data: OrbitalData,
)