package com.example.spacetechnology.features.profile.presentation

import android.content.Context
import android.net.Uri
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.auth.domain.DataStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream

class ViewModelProfile : ViewModel() {

    private val dataStore: DataStore by Injector.inject()
    private val context: Context by Injector.inject()

    private val _imageUri = MutableStateFlow<Uri?>(null)
    val imageUri = _imageUri.asStateFlow()

    private val _userEmail = MutableStateFlow("")
    val userEmail = _userEmail.asStateFlow()

    init {
        loadImageFromDevice()
        showEmailProfile()
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
                    if (it.isBlank()) _imageUri.value = null
                    else _imageUri.value = Uri.parse(it)
                }
            }
        }
    }

    private fun showEmailProfile() {
        viewModelScope.launch {
            dataStore.getUserData().collect {
                _userEmail.value = it.email
            }
        }
    }

    fun deleteProfile() {
        viewModelScope.launch {
            dataStore.deleteProfile()
            dataStore.setIsLoginUser(false)
        }
    }
}
