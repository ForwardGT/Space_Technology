package com.example.spacetechnology.cache

import io.github.reactivecircus.cache4k.CacheEvent
import io.github.reactivecircus.cache4k.CacheEventListener
import java.io.File

class FileDeleteEventListener : CacheEventListener<String, File> {
    override fun onEvent(event: CacheEvent<String, File>) {
        when(event) {
            is CacheEvent.Created -> {}
            is CacheEvent.Updated -> event.oldValue.delete()
            is CacheEvent.Evicted -> event.value.delete()
            is CacheEvent.Expired -> event.value.delete()
            is CacheEvent.Removed -> event.value.delete()
        }
    }
}
val fileDeleteEventListener = FileDeleteEventListener()