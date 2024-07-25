package com.example.spacetechnology.features.nasa.data.model

import com.google.gson.annotations.SerializedName

data class AsteroidsNearEarthObjectsDto(
    @SerializedName("near_earth_objects") val asteroids: List<AsteroidsDto>
)
