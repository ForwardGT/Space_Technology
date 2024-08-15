package com.example.spacetechnology.features.spacex.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LandPadsInformationDto(
    val name: String,
    val images: LandPadsInformationImageDto,
    val wikipedia: String,
    val status: String,
    val region: String,
    val details: String,
    val latitude: Double,
    val longitude: Double,
    val landing_attempts: Int,
    val landing_successes: Int,
    val type: String,
)
