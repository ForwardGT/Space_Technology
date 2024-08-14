package com.example.spacetechnology.features.my_posts.presentation

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.core.utils.deleteUnusedImages
import com.example.spacetechnology.core.utils.extensions.reduce
import com.example.spacetechnology.core.utils.saveImageToDevice
import com.example.spacetechnology.core.utils.validators.validatorPostsFromMyPosts
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.auth.domain.DataStore
import com.example.spacetechnology.features.my_posts.domain.entity.PostMyPosts
import com.example.spacetechnology.features.my_posts.domain.entity.TextFieldMyPostsError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelCreateMyPostScreen : ViewModel() {

    private val dataStore: DataStore by Injector.inject()
    private val context: Context by Injector.inject()

    private val _stateTextField = MutableStateFlow(PostMyPosts())
    val stateTextField = _stateTextField.asStateFlow()

    private val _errorTextField = MutableStateFlow(TextFieldMyPostsError())
    val errorTextField = _errorTextField.asStateFlow()

    private val _myPosts = MutableStateFlow<List<PostMyPosts>>(listOf())
    val myPosts = _myPosts.asStateFlow()


    init {
        getPostsFromMyPosts()
    }

    private fun getPostsFromMyPosts() {
        viewModelScope.launch {
            dataStore.getPostsForMyPosts().collect {
                _myPosts.value = it
            }
            Log.d("TAG", "setPostsToMyPosts: +1post ${_myPosts.value}")
        }
    }

    fun ooo(str: String) {
        _stateTextField.reduce {
            it.copy(imageUri = str)
        }

    }

    fun saveImage(uri: Uri) {
        viewModelScope.launch {
            val file = saveImageToDevice(uri, context, "${System.currentTimeMillis()}.jpg")
            deleteUnusedImages(context)
            _stateTextField.reduce {
                it.copy(imageUri = file.toURI().toString())
            }
        }
    }

    fun setPostsToMyPosts(onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val errors = validatorPostsFromMyPosts(
                _stateTextField.value.title,
                _stateTextField.value.description,
                _stateTextField.value.imageUri,
            )
            _errorTextField.value = errors

            if (_errorTextField.value.titleError.isBlank() &&
                _errorTextField.value.descriptionError.isBlank() &&
                _errorTextField.value.imageError.isBlank()
            ) {
                dataStore.setPost(_stateTextField.value)
                onResult(true)
            }
        }
    }


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


    fun addImageToPosts(uri: Uri) {
        viewModelScope.launch {
            _stateTextField.reduce {
                it.copy(imageUri = uri.toString())
            }
        }
    }
}