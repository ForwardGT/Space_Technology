package com.example.spacetechnology.features.nasa.data.model

import com.google.gson.annotations.SerializedName

data class AsteroidsObjectsDto(
    @SerializedName("") val aster: AsteroidsNearEarthObjectsDto
)
