package com.example.spacetechnology.core.utils.extensions

import androidx.compose.ui.Modifier

fun Modifier.thenIf(
    condition: Boolean, modifier: Modifier
): Modifier {
    return if (condition) this.then(modifier) else this
}