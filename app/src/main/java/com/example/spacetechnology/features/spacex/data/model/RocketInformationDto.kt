package com.example.spacetechnology.features.spacex.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RocketInformationDto(
    val flickr_images: List<String>,
    val boosters: Int,
    val name: String,
    val first_flight: String,
    val stages: Int,
    val description: String,
    val wikipedia: String,
    val height: HeightRocketDto,
    val diameter: DiameterRocketDto
)