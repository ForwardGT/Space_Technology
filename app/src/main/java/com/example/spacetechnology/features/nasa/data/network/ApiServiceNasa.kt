package com.example.spacetechnology.features.nasa.data.network


import com.example.spacetechnology.features.nasa.data.model.PostApodDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceNasa {
    @GET("planetary/apod?")
    suspend fun getLastApod(
        @Query("api_key") apiKey: String,
    ): PostApodDto
}
