package com.example.spacetechnology.features.nasa.data.repository

import com.example.spacetechnology.features.nasa.data.mapper.mapperApod
import com.example.spacetechnology.features.nasa.data.network.ApiFactoryNasa
import com.example.spacetechnology.features.nasa.data.network.apiKeyNasa
import com.example.spacetechnology.features.nasa.domain.entity.PostApod
import com.example.spacetechnology.features.nasa.domain.entity.RepositoryNasa

class RepositoryNasaImpl : RepositoryNasa {

    override suspend fun loadApod(): PostApod {
        val apiService = ApiFactoryNasa.apiService.getLastApod(apiKeyNasa)
        val post = mapperApod(apiService)
        return post
    }

}