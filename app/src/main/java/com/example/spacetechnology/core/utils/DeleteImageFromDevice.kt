package com.example.spacetechnology.core.utils

import android.content.Context
import java.io.File

fun deleteImageFromDevice(context: Context, nameImage: String): Boolean {
    val file = File(context.filesDir, nameImage)
    return if (file.exists()) {
        file.delete()
    } else {
        false
    }
}