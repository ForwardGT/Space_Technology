package com.example.spacetechnology.features.spacex.data.model

import com.google.gson.annotations.SerializedName

data class LandPadsInformationDto(
    @SerializedName("name") val name: String,
    @SerializedName("images") val images: LandPadsInformationImageDto,
    @SerializedName("wikipedia") val wikipedia: String,
    @SerializedName("status") val status: String,
    @SerializedName("region") val region: String,
    @SerializedName("details") val description: String,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("landing_attempts") val landingAttempts: Int,
    @SerializedName("landing_successes") val landingSuccesses: Int,
    @SerializedName("type") val type: String,
)
