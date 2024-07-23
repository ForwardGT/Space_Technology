package com.example.spacetechnology.features.spacex.data.repository

import com.example.spacetechnology.features.spacex.data.mapper.mapperSpacexDragon
import com.example.spacetechnology.features.spacex.data.mapper.mapperSpacexLandPads
import com.example.spacetechnology.features.spacex.data.mapper.mapperSpacexRocket
import com.example.spacetechnology.features.spacex.data.network.ApiFactorySpacex
import com.example.spacetechnology.features.spacex.domain.RepositorySpacex
import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon
import com.example.spacetechnology.features.spacex.domain.entity.SpacexLandPads
import com.example.spacetechnology.features.spacex.domain.entity.SpacexRocket

class RepositorySpacexImpl : RepositorySpacex {

    override suspend fun loadDragon(): List<SpacexDragon> {
        val response = ApiFactorySpacex.apiService.getDragons()
        val dragons = mapperSpacexDragon(response)
        return dragons
    }

    override suspend fun loadRocket(): List<SpacexRocket> {
        val response = ApiFactorySpacex.apiService.getRockets()
        val rockets = mapperSpacexRocket(response)
        return rockets
    }

    override suspend fun loadLandPads(): List<SpacexLandPads> {
        val response = ApiFactorySpacex.apiService.getLandPads()
        val crew = mapperSpacexLandPads(response)
        return crew
    }
}