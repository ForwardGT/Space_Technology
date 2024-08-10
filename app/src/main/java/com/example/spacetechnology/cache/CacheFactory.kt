package com.example.spacetechnology.cache

import com.example.spacetechnology.features.nasa.domain.entity.Asteroid
import com.example.spacetechnology.features.nasa.domain.entity.PostApodNasa
import com.example.spacetechnology.features.nasa.domain.entity.PostTechTransfer
import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon
import com.example.spacetechnology.features.spacex.domain.entity.SpacexLandPads
import com.example.spacetechnology.features.spacex.domain.entity.SpacexRocket
import io.github.reactivecircus.cache4k.Cache
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

interface CacheFactory {

    fun <T : Any> createCache(time: Duration = 5.minutes): Cache<String, T>

    fun dragonCache(): Cache<String, List<SpacexDragon>>

    fun rocketCache(): Cache<String, List<SpacexRocket>>

    fun landPadsCache(): Cache<String, List<SpacexLandPads>>

    fun apodCache() :Cache<String, PostApodNasa>

    fun techTransferCache() :Cache<String, List<PostTechTransfer>>

    fun asteroidsCache() :Cache<String, List<Asteroid>>

}