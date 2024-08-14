package com.example.spacetechnology.core.utils

import android.content.Context

fun deleteUnusedImages(context: Context) {
    val files = context.filesDir.listFiles()
        ?.filter { it.extension == "jpg" }
        ?.sortedBy { it.lastModified() }
        ?: return

    val keepLastFiles = files.takeLast(2)
    files.forEach { file ->
        if (file !in keepLastFiles) {
            file.delete()
        }
    }
}