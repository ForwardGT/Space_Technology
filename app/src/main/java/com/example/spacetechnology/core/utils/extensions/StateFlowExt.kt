package com.example.spacetechnology.core.utils.extensions

import kotlinx.coroutines.flow.MutableStateFlow

fun <T> MutableStateFlow<T>.reduce(update: (T) -> T) {
    this.value = update(this.value)
}