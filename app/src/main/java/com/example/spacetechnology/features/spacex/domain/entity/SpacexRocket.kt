package com.example.spacetechnology.features.spacex.domain.entity

data class SpacexRocket(
    val name: String = "",
    val boosters: Int = 0,
    val firstFlight: String = "",
    val stages: Int = 0,
    val image: List<String> = listOf(),
    val wikipedia: String = "",
    val height: Float = 0f,
    val diameter: Float = 0f,
    val description: String = "Rockets: Explore SpaceX's innovative designs and powerful launch vehicles."
)