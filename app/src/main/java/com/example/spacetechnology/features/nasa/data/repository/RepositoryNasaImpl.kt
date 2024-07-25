package com.example.spacetechnology.features.nasa.data.repository

import com.example.spacetechnology.features.nasa.data.mapper.mapperApodNasa
import com.example.spacetechnology.features.nasa.data.mapper.mapperTechNasa
import com.example.spacetechnology.features.nasa.data.network.ApiFactoryNasa
import com.example.spacetechnology.features.nasa.data.network.apiKeyNasa
import com.example.spacetechnology.features.nasa.domain.entity.PostApodNasa
import com.example.spacetechnology.features.nasa.domain.entity.PostTechTransfer
import com.example.spacetechnology.features.nasa.domain.entity.RepositoryNasa

class RepositoryNasaImpl : RepositoryNasa {

    override suspend fun loadApod(): PostApodNasa {
        val apiService = ApiFactoryNasa.apiService.getLastApod(apiKeyNasa)
        val post = mapperApodNasa(apiService)
        return post
    }

    override suspend fun loadTechTransfer(): List<PostTechTransfer> {
        val apiService = ApiFactoryNasa.apiService.getTechTransfer(apiKeyNasa)
        val post = mapperTechNasa(apiService)
        return post
    }

}