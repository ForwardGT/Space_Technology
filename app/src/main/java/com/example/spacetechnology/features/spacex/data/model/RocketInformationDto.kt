package com.example.spacetechnology.features.spacex.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RocketInformationDto(
    val boosters: Int,
    val name: String,
    val first: String,
    val stages: Int,
    val flickr_images: List<String>,
    val description: String,
    val wikipedia: String,
    val height: HeightRocketDto,
    val diameter: DiameterRocketDto
)