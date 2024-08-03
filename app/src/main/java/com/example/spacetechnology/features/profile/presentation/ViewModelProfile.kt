package com.example.spacetechnology.features.profile.presentation

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.auth.domain.DataStoreManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream

class ViewModelProfile : ViewModel() {

    private val dataStore: DataStoreManager by Injector.inject()
    private val context: Context by Injector.inject()

    private val _imageUri = MutableStateFlow<Uri?>(null)
    val imageUri = _imageUri.asStateFlow()

    init {
        load()
    }


    fun save(uri: Uri) {
        viewModelScope.launch {
            val file = File(context.filesDir, "profile_photo.jpg")
            context.contentResolver.openInputStream(uri)?.use { input ->
                FileOutputStream(file).use { output ->
                    input.copyTo(output)
                    output.close()
                    input.close()
                }
            }
            dataStore.setProfileImagePath(file.toURI().toString())
            _imageUri.update { file.toUri() }
        }
    }

    private fun load() {
        viewModelScope.launch {
            dataStore.getProfileImagePath().collect {
                it?.let {
                    _imageUri.value = Uri.parse(it)
                }
            }
            Log.d("TAG", "load: getProfileImagePath = ${_imageUri.value}")
        }
    }
}
