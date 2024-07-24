package com.example.spacetechnology.features.nasa.domain.entity

interface RepositoryNasa {

    suspend fun loadApod(): PostApod

}