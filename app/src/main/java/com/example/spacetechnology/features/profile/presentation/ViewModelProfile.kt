package com.example.spacetechnology.features.profile.presentation

import android.content.Context
import android.net.Uri
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.core.utils.deleteImageFromDevice
import com.example.spacetechnology.core.utils.extensions.reduce
import com.example.spacetechnology.core.utils.saveImageToDevice
import com.example.spacetechnology.dao.DataStore
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.nasa.domain.entity.RepositoryNasa
import com.example.spacetechnology.features.spacex.domain.RepositorySpacex
import com.example.spacetechnology.notification.SubscribeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelProfile : ViewModel() {

    private val repositorySpacex: RepositorySpacex by Injector.inject()
    private val repositoryNasa: RepositoryNasa by Injector.inject()
    private val dataStore: DataStore by Injector.inject()
    private val context: Context by Injector.inject()

    private val _imageUri = MutableStateFlow<Uri?>(null)
    val imageUri = _imageUri.asStateFlow()

    private val _userEmail = MutableStateFlow("")
    val userEmail = _userEmail.asStateFlow()

    private val _stateSubscribe = MutableStateFlow(SubscribeState())
    val stateSubscribe = _stateSubscribe.asStateFlow()

    init {
        loadStateSubscribe()
        loadImageFromDevice()
        showEmailProfile()
    }

    private fun loadStateSubscribe() {
        viewModelScope.launch {
            dataStore.getSubscribeTopic().collect { pref ->
                _stateSubscribe.reduce {
                    it.copy(
                        news = pref.news,
                        sales = pref.sales
                    )
                }
            }
        }
    }

    private fun setStateSubscribeDao() {
        viewModelScope.launch {
            dataStore.setSubscribeTopic(_stateSubscribe.value)
        }
    }

    fun setStateSubscribeSales(sales: Boolean) {
        _stateSubscribe.reduce {
            it.copy(sales = sales)
        }
        setStateSubscribeDao()
    }

    fun setStateSubscribeNews(news: Boolean) {
        _stateSubscribe.reduce {
            it.copy(news = news)
        }
        setStateSubscribeDao()
    }

    fun clearCache() {
        viewModelScope.launch {
            repositorySpacex.clearCache()
            repositoryNasa.clearCache()
        }
    }

    fun saveImage(uri: Uri) {
        viewModelScope.launch {
            val file = saveImageToDevice(uri, context, "profile_photo.jpg")
            dataStore.setProfileImagePath(file.toURI().toString())
            _imageUri.value = file.toUri()
        }
    }

    fun clearImageFromDevise() {
        viewModelScope.launch {
            if (deleteImageFromDevice(context, "profile_photo.jpg")) {
                dataStore.clearPhotoImagePath()
                _imageUri.value = null
            }
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
