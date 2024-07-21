package com.example.spacetechnology.features.home.domain.entity

data class SpacexPostDragon(
    val name: String = "",
    val type: String = "",
    val active: String = "",
    val crewCapacity: Int = 0,
    val diameter: Float = 0f,
    val dryMassKg: Int = 0,
    val wikipedia: String = "",
    val image: List<String> = listOf(),
    val description: String = "Dragon spacecraft: Learn about the revolutionary vessels for cargo and crewed missions",
)