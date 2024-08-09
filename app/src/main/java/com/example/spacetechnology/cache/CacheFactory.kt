package com.example.spacetechnology.cache

import io.github.reactivecircus.cache4k.Cache
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

object CacheFactory {

    fun <T : Any> createCache(time: Duration = 5.minutes): Cache<String, T> {
        return Cache.Builder<String, T>()
            .expireAfterWrite(time)
            .build()
    }
}