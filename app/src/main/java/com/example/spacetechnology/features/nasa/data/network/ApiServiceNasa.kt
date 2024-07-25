package com.example.spacetechnology.features.nasa.data.network


import com.example.spacetechnology.features.nasa.data.model.PostApodDto
import com.example.spacetechnology.features.nasa.data.model.PostsTechTransferDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceNasa {

    @GET("planetary/apod?")
    suspend fun getLastApod(
        @Query("api_key") apiKey: String,
    ): PostApodDto

    @GET("techtransfer/patent/?engine")
    suspend fun getTechTransfer(
        @Query("api_key") apiKey: String,
    ): PostsTechTransferDto

}
