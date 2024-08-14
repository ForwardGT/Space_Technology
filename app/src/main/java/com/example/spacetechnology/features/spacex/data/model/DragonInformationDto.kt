package com.example.spacetechnology.features.spacex.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DragonInformationDto(
    val name: String,
    val type: String,
    val crew_capacity: Int,
    val diameter: DiameterDragonDto,
    val dry_mass_kg: Int,
    val wikipedia: String,
    val flickr_images: List<String>,
    val description: String,
    val launch_payload_mass: LaunchPayLoadMassKgDto,
)
