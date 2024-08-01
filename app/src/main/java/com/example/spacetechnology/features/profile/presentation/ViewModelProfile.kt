package com.example.spacetechnology.features.profile.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.auth.domain.DataStoreManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelProfile : ViewModel() {

    private val dataStore: DataStoreManager by Injector.inject()
    private val context: Context by Injector.inject()

    private val _imageUri = MutableStateFlow<String?>(null)
    val imageUri: StateFlow<String?> = _imageUri.asStateFlow()

    init {
        load()
    }


    fun save(s: String) {
        viewModelScope.launch {
            dataStore.setProfileImagePath(s)
            _imageUri.value = s
        }
    }

    fun load() {
        viewModelScope.launch {
            dataStore.getProfileImagePath().collect {
                Log.d("TAG", "load: getProfileImagePath = $it")
                _imageUri.value = it
            }
            Log.d("TAG", "load: getProfileImagePath = ${_imageUri.value}")
        }
    }
}
