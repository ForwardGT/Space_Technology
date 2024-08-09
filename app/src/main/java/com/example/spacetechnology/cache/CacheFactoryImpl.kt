package com.example.spacetechnology.cache

import io.github.reactivecircus.cache4k.Cache
import kotlin.time.Duration

class CacheFactoryImpl : CacheFactory {

    override fun <T : Any> createCache(time: Duration): Cache<String, T> {
        return Cache.Builder<String, T>()
            .expireAfterWrite(time)
            .build()
    }

}