package com.example.spacetechnology.core.utils

import android.content.Context
import android.net.Uri
import java.io.File
import java.io.FileOutputStream

fun saveImageToDevice(uri: Uri, context: Context, nameSaveImage: String): File {
    val file = File(context.filesDir, nameSaveImage)
    context.contentResolver.openInputStream(uri)?.use { input ->
        FileOutputStream(file).use { output ->
            input.copyTo(output)
        }
    }
    return file
}