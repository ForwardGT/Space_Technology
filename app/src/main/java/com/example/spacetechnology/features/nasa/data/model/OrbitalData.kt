package com.example.spacetechnology.features.nasa.data.model

import com.google.gson.annotations.SerializedName

data class OrbitalData(
    @SerializedName("orbit_determination_date") val orbitDeterminationDate: String,
    @SerializedName("first_observation_date") val firstObservationDate: String,
    @SerializedName("orbit_class") val orbitClass: OrbitalClassDto
)