package com.example.spacetechnology.features.profile.presentation

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.spacetechnology.R
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.auth.domain.DataStoreManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.File
import java.io.FileOutputStream

class ViewModelProfile : ViewModel() {

    private val dataStore: DataStoreManager by Injector.inject()
    private val context: Context by Injector.inject()

    private val _imageUri = MutableStateFlow<String?>(null)
    val imageUri: StateFlow<String?> = _imageUri.asStateFlow()

    init {

    }



    fun saveImageToInternalStorage(imageBitmap: Bitmap, filename: String): String {
        val file = File(context.filesDir, filename)
        FileOutputStream(file).use { out ->
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            out.close()
        }
        return file.absolutePath
    }


    fun ProfileImage(

    ) {

        if (dataStore.getProfileImagePath() != null) {
            val painter = rememberAsyncImagePainter(model = File(profileImagePath))
            Image(painter = painter, contentDescription = null)
        } else {
            // Заглушка для отсутствующего изображения
            Image(painter = painterResource(R.drawable.placeholder), contentDescription = null)
        }
    }



}
