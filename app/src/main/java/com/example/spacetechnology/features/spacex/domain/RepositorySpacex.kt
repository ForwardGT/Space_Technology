package com.example.spacetechnology.features.spacex.domain

import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon
import com.example.spacetechnology.features.spacex.domain.entity.SpacexLandPads
import com.example.spacetechnology.features.spacex.domain.entity.SpacexRocket

interface RepositorySpacex {

    suspend fun loadDragon(): List<SpacexDragon>

    suspend fun loadRocket(): List<SpacexRocket>

    suspend fun loadLandPads(): List<SpacexLandPads>

}