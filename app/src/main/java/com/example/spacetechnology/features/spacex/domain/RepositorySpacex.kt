package com.example.spacetechnology.features.spacex.domain

import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon

interface RepositorySpacex {

    suspend fun loadDragon(): List<SpacexDragon>



}