package com.example.spacetechnology.features.spacex.data.repository

import com.example.spacetechnology.features.spacex.data.mapper.mapperSpacexDragon
import com.example.spacetechnology.features.spacex.data.network.ApiFactorySpacex
import com.example.spacetechnology.features.spacex.domain.RepositorySpacex
import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon

class RepositorySpacexImpl : RepositorySpacex {

    override suspend fun loadDragon(): List<SpacexDragon> {
        val response = ApiFactorySpacex.apiService.getDragon()
        val dragons = mapperSpacexDragon(response)
        return dragons
    }

}