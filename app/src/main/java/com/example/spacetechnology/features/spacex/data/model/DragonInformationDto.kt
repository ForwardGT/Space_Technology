package com.example.spacetechnology.features.spacex.data.model

import com.google.gson.annotations.SerializedName

data class DragonInformationDto(
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("crew_capacity") val crewCapacity: Int,
    @SerializedName("diameter") val diameter: DiameterDragonDto,
    @SerializedName("dry_mass_kg") val dryMassKg: Int,
    @SerializedName("wikipedia") val wikipedia: String,
    @SerializedName("flickr_images") val image: List<String>,
    @SerializedName("description") val description: String,
    @SerializedName("launch_payload_mass") val launchPayloadMass: LaunchPayLoadMassKgDto,
)
