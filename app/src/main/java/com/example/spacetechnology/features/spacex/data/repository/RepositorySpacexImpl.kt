package com.example.spacetechnology.features.spacex.data.repository

import com.example.spacetechnology.cache.CacheFactory
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.spacex.data.mapper.mapperSpacexDragon
import com.example.spacetechnology.features.spacex.data.mapper.mapperSpacexLandPads
import com.example.spacetechnology.features.spacex.data.mapper.mapperSpacexRocket
import com.example.spacetechnology.features.spacex.data.network.ApiServiceKtorSpacex
import com.example.spacetechnology.features.spacex.domain.RepositorySpacex
import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon
import com.example.spacetechnology.features.spacex.domain.entity.SpacexLandPads
import com.example.spacetechnology.features.spacex.domain.entity.SpacexRocket

class RepositorySpacexImpl : RepositorySpacex {

    private val cache: CacheFactory by Injector.inject()
    private val apiService: ApiServiceKtorSpacex by Injector.inject()

    private val dragonCache = cache.dragonCache()
    private val rocketCache = cache.rocketCache()
    private val landPadsCache = cache.landPadsCache()

    override suspend fun loadDragon(): List<SpacexDragon> {
        return dragonCache.get(DRAGON) {
            val response = apiService.getDragons()
            mapperSpacexDragon(response)
        }
    }

    override suspend fun loadRocket(): List<SpacexRocket> {
        return rocketCache.get(ROCKET) {
            val response = apiService.getRockets()
            mapperSpacexRocket(response)
        }
    }

    override suspend fun loadLandPads(): List<SpacexLandPads> {
        return landPadsCache.get(LAND_PADS) {
            val response = apiService.getLandPads()
            mapperSpacexLandPads(response)
        }
    }

    override suspend fun clearCache() {
        dragonCache.invalidateAll()
        rocketCache.invalidateAll()
        landPadsCache.invalidateAll()
    }

    private companion object {
        const val LAND_PADS = "land_pads"
        const val ROCKET = "rocket"
        const val DRAGON = "dragon"
    }
}