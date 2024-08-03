package com.example.spacetechnology.features.profile.presentation

import android.content.Context
import android.net.Uri
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.auth.domain.DataStoreManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream

class ViewModelProfile : ViewModel() {

    private val dataStore: DataStoreManager by Injector.inject()
    private val context: Context by Injector.inject()

    private val _imageUri = MutableStateFlow<Uri?>(null)
    val imageUri = _imageUri.asStateFlow()

    init {
        loadImageFromDevice()
    }

    fun saveImageToDevice(uri: Uri) {
        viewModelScope.launch {
            val file = File(context.filesDir, "profile_photo.jpg")
            context.contentResolver.openInputStream(uri)?.use { input ->
                FileOutputStream(file).use { output ->
                    input.copyTo(output)
                }
            }
            dataStore.setProfileImagePath(file.toURI().toString())
            _imageUri.value = file.toUri()
        }
    }

    fun clearPhotoImagePath() {
        viewModelScope.launch {
            dataStore.clearPhotoImagePath()
            _imageUri.value = null
        }
    }

    private fun loadImageFromDevice() {
        viewModelScope.launch {
            dataStore.getProfileImagePath().collect {
                it?.let {
                    _imageUri.value = Uri.parse(it)
                }
            }
        }
    }
}
