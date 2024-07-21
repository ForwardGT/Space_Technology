package com.example.spacetechnology.features.spacex.data.network


import com.example.spacetechnology.features.spacex.data.model.CrewInformationDto
import com.example.spacetechnology.features.spacex.data.model.DragonInformationDto
import com.example.spacetechnology.features.spacex.data.model.RocketInformationDto
import retrofit2.http.GET

interface ApiServiceSpacex {
    @GET("rockets")
    suspend fun getRocket(): List<RocketInformationDto>

    @GET("crew")
    suspend fun getCrew(): List<CrewInformationDto>

    @GET("dragons")
    suspend fun getDragon(): List<DragonInformationDto>
}
