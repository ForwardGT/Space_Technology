package com.example.spacetechnology.features.spacex.domain.entity

data class SpacexRocket(
    val name: String,
    val boosters: Int,
    val firstFlight: String,
    val stages: Int,
    val image: List<String>,
    val wikipedia: String,
    val height: Float,
    val diameter: Float,
    val description: String
)