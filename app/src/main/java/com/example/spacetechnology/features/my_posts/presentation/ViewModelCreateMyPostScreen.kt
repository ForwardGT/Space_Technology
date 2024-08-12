package com.example.spacetechnology.features.my_posts.presentation

import android.content.Context
import android.net.Uri
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.core.utils.extensions.reduce
import com.example.spacetechnology.core.utils.saveImageToDevice
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.auth.domain.DataStore
import com.example.spacetechnology.features.my_posts.domain.entity.PostMyPostsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelCreateMyPostScreen : ViewModel() {

    private val context: Context by Injector.inject()
    private val dataStore: DataStore by Injector.inject()

    private val _stateTextField = MutableStateFlow(PostMyPostsState())
    val stateTextField = _stateTextField.asStateFlow()

    fun changeTitle(str: String) {
        _stateTextField.reduce {
            it.copy(title = str)
        }
    }

    fun changeDescription(str: String) {
        _stateTextField.reduce {
            it.copy(description = str)
        }
    }

    fun saveImage(uri: Uri) {
        viewModelScope.launch {
            val file = saveImageToDevice(uri, context, "image_from_create_post")
            _stateTextField.reduce {
                it.copy(imageUri = file.toUri())
            }
        }
    }
}