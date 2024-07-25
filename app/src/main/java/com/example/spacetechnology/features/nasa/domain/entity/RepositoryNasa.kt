package com.example.spacetechnology.features.nasa.domain.entity

interface RepositoryNasa {

    suspend fun loadApod(): PostApodNasa

    suspend fun loadTechTransfer(): List<PostTechTransfer>

    suspend fun loadAsteroids(): List<Asteroid>

}