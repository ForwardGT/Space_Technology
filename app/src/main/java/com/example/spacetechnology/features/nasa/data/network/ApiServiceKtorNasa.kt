package com.example.spacetechnology.features.nasa.data.network

import com.example.spacetechnology.features.nasa.data.model.AsteroidsNearEarthObjectsDto
import com.example.spacetechnology.features.nasa.data.model.PostApodDto
import com.example.spacetechnology.features.nasa.data.model.PostsTechTransferDto
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiServiceKtorNasa {

    suspend fun getAsteroids(): AsteroidsNearEarthObjectsDto {
        return ApiFactoryKtorNasa.client.get("neo/rest/v1/neo/browse?").body()
    }

    suspend fun getTechTransfer(): PostsTechTransferDto {
        return ApiFactoryKtorNasa.client.get("techtransfer/patent/?engine").body()
    }

    suspend fun getLastApod(): PostApodDto {
        return ApiFactoryKtorNasa.client.get("planetary/apod?").body()
    }

}