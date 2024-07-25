package com.example.spacetechnology.features.nasa.domain.entity

data class Asteroid(
    val name: String,
    val url: String,
    val absMagnitude: Float,
    val estimatedDiameterMin: Double,
    val estimatedDiameterMax: Double,
    val orbitDeterminationDate: String,
    val firstObservationDate: String,
    val orbitClassType: String,
    val orbitClassDescription: String,
)
