package com.example.spacetechnology.cache

import com.example.spacetechnology.features.nasa.domain.entity.Asteroid
import com.example.spacetechnology.features.nasa.domain.entity.PostApodNasa
import com.example.spacetechnology.features.nasa.domain.entity.PostTechTransfer
import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon
import com.example.spacetechnology.features.spacex.domain.entity.SpacexLandPads
import com.example.spacetechnology.features.spacex.domain.entity.SpacexRocket
import io.github.reactivecircus.cache4k.Cache
import kotlin.time.Duration

class CacheFactoryImpl : CacheFactory {

    override fun <T : Any> createCache(time: Duration): Cache<String, T> {
        return Cache.Builder<String, T>()
            .expireAfterWrite(time)
            .build()
    }

    override fun dragonCache(): Cache<String, List<SpacexDragon>> {
        return createCache()
    }

    override fun rocketCache(): Cache<String, List<SpacexRocket>> {
        return createCache()
    }

    override fun landPadsCache(): Cache<String, List<SpacexLandPads>> {
        return createCache()
    }

    override fun apodCache(): Cache<String, PostApodNasa> {
        return createCache()
    }

    override fun techTransferCache(): Cache<String, List<PostTechTransfer>> {
        return createCache()
    }

    override fun asteroidsCache(): Cache<String, List<Asteroid>> {
        return createCache()
    }

}