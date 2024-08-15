package com.example.spacetechnology.features.spacex.data.network

import com.example.spacetechnology.features.spacex.data.model.DragonInformationDto
import com.example.spacetechnology.features.spacex.data.model.LandPadsInformationDto
import com.example.spacetechnology.features.spacex.data.model.RocketInformationDto
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiServiceKtorSpacex {

    suspend fun getRockets(): List<RocketInformationDto> {
        return ApiFactoryKtorSpacex.client.get("v4/rockets").body()
    }

    suspend fun getLandPads(): List<LandPadsInformationDto> {
        return ApiFactoryKtorSpacex.client.get("v4/landpads").body()
    }

    suspend fun getDragons(): List<DragonInformationDto> {
        return ApiFactoryKtorSpacex.client.get("v4/dragons").body()
    }

}