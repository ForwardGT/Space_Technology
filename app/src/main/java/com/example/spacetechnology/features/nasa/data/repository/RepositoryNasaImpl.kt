package com.example.spacetechnology.features.nasa.data.repository

import com.example.spacetechnology.cache.CacheFactory
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

    private val apodCache by lazy { CacheFactory.createCache<PostApodNasa>() }
    private val techTransferCache by lazy { CacheFactory.createCache<List<PostTechTransfer>>() }
    private val asteroidsCache by lazy { CacheFactory.createCache<List<Asteroid>>() }

    override suspend fun loadApod(): PostApodNasa {
        return apodCache.get(key = APOD) {
            val responseApiService = ApiFactoryNasa.apiService.getLastApod(apiKeyNasa)
            mapperApodNasa(responseApiService)
        }
    }

    override suspend fun loadTechTransfer(): List<PostTechTransfer> {
        return techTransferCache.get(key = TECH_TRANSFER) {
            val responseApiService = ApiFactoryNasa.apiService.getTechTransfer(apiKeyNasa)
            mapperTechNasa(responseApiService)
        }
    }

    override suspend fun loadAsteroids(): List<Asteroid> {
        return asteroidsCache.get(key = ASTEROIDS) {
            val responseApiService = ApiFactoryNasa.apiService.getAsteroids(apiKeyNasa)
            mapperAsteroidsNasa(responseApiService)
        }
    }

    override suspend fun clearCache() {
        apodCache.invalidateAll()
        techTransferCache.invalidateAll()
        asteroidsCache.invalidateAll()
    }

    private companion object {
        const val ASTEROIDS = "asteroids"
        const val APOD = "apod"
        const val TECH_TRANSFER = "techTransfer"
    }
}