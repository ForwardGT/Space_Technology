package com.example.spacetechnology.features.nasa.data.model

import com.google.gson.annotations.SerializedName

data class EstimatedDiameterMetersDto(
    @SerializedName("estimated_diameter_min") val estimatedDiameterMin: Double,
    @SerializedName("estimated_diameter_max") val estimatedDiameterMax: Double,
)