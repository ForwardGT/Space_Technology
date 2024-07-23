package com.example.spacetechnology.features.spacex.domain.entity

data class SpacexLandPads(
    val name: String,
    val image: List<String>,
    val region: String,
    val status: String,
    val description: String,
    val latitude: Double,
    val landingAttempts: Int,
    val landingSuccesses: Int,
    val wikipedia: String,
    val type: String,
    val longitude: Double,
)