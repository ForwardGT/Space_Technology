package com.example.spacetechnology.features.spacex.domain.entity

data class SpacexCrew(
    val id: Int = 0,
    val name: String = "",
    val agency: String = "",
    val image: String = "",
    val wikipedia: String = "",
    val status: String = "",
    val description: String = "Meet the astronauts: Discover the heroes embarking on SpaceX missions."
)