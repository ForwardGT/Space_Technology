package com.example.spacetechnology.features.nasa.data.repository

import com.example.spacetechnology.features.nasa.data.mapper.mapperApodNasa
import com.example.spacetechnology.features.nasa.data.mapper.mapperAsteroidsNasa
import com.example.spacetechnology.features.nasa.data.mapper.mapperTechNasa
import com.example.spacetechnology.features.nasa.data.network.ApiFactoryNasa
import com.example.spacetechnology.features.nasa.data.network.apiKeyNasa
import com.example.spacetechnology.features.nasa.domain.entity.Asteroid
import com.example.spacetechnology.features.nasa.domain.entity.PostApodNasa
import com.example.spacetechnology.features.nasa.domain.entity.PostTechTransfer
import com.example.spacetechnology.features.nasa.domain.entity.RepositoryNasa

class RepositoryNasaImpl : RepositoryNasa {

    override suspend fun loadApod(): PostApodNasa {
        val responseApiService = ApiFactoryNasa.apiService.getLastApod(apiKeyNasa)
        val post = mapperApodNasa(responseApiService)
        return post
    }

    override suspend fun loadTechTransfer(): List<PostTechTransfer> {
        val responseApiService = ApiFactoryNasa.apiService.getTechTransfer(apiKeyNasa)
        val post = mapperTechNasa(responseApiService)
        return post
    }

    override suspend fun loadAsteroids(): List<Asteroid> {
        val responseApiService = ApiFactoryNasa.apiService.getAsteroids(apiKeyNasa)
        val post = mapperAsteroidsNasa(responseApiService)
        return post
    }

}