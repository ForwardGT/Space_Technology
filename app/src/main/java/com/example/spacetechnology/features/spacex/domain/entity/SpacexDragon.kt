package com.example.spacetechnology.features.spacex.domain.entity

data class SpacexDragon(
    val name: String,
    val type: String,
    val crewCapacity: Int,
    val diameter: Float,
    val dryMassKg: Int,
    val wikipedia: String,
    val image: List<String>,
    val description: String,
    val launchPayloadMass: Int
)