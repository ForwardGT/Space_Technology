package com.example.spacetechnology.features.spacex.data.model

import com.google.gson.annotations.SerializedName

data class LandPadsInformationImageDto(
    @SerializedName("large") val large: List<String>
)
