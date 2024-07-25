package com.example.spacetechnology.features.spacex.data.network


import com.example.spacetechnology.features.spacex.data.model.DragonInformationDto
import com.example.spacetechnology.features.spacex.data.model.LandPadsInformationDto
import com.example.spacetechnology.features.spacex.data.model.RocketInformationDto
import retrofit2.http.GET

interface ApiServiceSpacex {

    @GET("rockets")
    suspend fun getRockets(): List<RocketInformationDto>

    @GET("landpads")
    suspend fun getLandPads(): List<LandPadsInformationDto>

    @GET("dragons")
    suspend fun getDragons(): List<DragonInformationDto>

}
