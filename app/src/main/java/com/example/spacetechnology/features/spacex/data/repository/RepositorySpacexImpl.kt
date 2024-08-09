package com.example.spacetechnology.features.spacex.data.repository

import com.example.spacetechnology.features.spacex.data.mapper.mapperSpacexDragon
import com.example.spacetechnology.features.spacex.data.mapper.mapperSpacexLandPads
import com.example.spacetechnology.features.spacex.data.mapper.mapperSpacexRocket
import com.example.spacetechnology.features.spacex.data.network.ApiFactorySpacex
import com.example.spacetechnology.features.spacex.domain.RepositorySpacex
import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon
import com.example.spacetechnology.features.spacex.domain.entity.SpacexLandPads
import com.example.spacetechnology.features.spacex.domain.entity.SpacexRocket
import io.github.reactivecircus.cache4k.Cache
import kotlin.time.Duration.Companion.minutes

class RepositorySpacexImpl : RepositorySpacex {

    private val dragonCache = Cache.Builder<String, List<SpacexDragon>>()
        .expireAfterWrite(5.minutes)
        .build()

    private val rocketCache = Cache.Builder<String, List<SpacexRocket>>()
        .expireAfterWrite(5.minutes)
        .build()

    private val landPadsCache = Cache.Builder<String, List<SpacexLandPads>>()
        .expireAfterWrite(5.minutes)
        .build()

    override suspend fun loadDragon(): List<SpacexDragon> {
        return dragonCache.get(DRAGON) {
            val response = ApiFactorySpacex.apiService.getDragons()
            mapperSpacexDragon(response)
        }
    }

    override suspend fun loadRocket(): List<SpacexRocket> {
        return rocketCache.get(ROCKET) {
            val response = ApiFactorySpacex.apiService.getRockets()
            mapperSpacexRocket(response)
        }
    }

    override suspend fun loadLandPads(): List<SpacexLandPads> {
        return landPadsCache.get(LAND_PADS) {
            val response = ApiFactorySpacex.apiService.getLandPads()
            mapperSpacexLandPads(response)
        }
    }

    private companion object {
        const val LAND_PADS = "land_pads"
        const val ROCKET = "rocket"
        const val DRAGON = "dragon"
    }
}