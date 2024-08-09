package com.example.spacetechnology.cache

import io.github.reactivecircus.cache4k.Cache
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

interface CacheFactory {

    fun <T : Any> createCache(time: Duration = 5.minutes): Cache<String, T>

}