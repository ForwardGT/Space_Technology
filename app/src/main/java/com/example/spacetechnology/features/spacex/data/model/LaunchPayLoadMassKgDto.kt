package com.example.spacetechnology.features.spacex.data.model

import com.google.gson.annotations.SerializedName

data class LaunchPayLoadMassKgDto(
    @SerializedName("kg") val kg: Int
)
