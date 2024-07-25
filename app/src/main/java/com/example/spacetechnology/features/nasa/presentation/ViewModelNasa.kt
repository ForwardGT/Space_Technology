package com.example.spacetechnology.features.nasa.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.core.utils.extensions.isError
import com.example.spacetechnology.core.utils.extensions.reduce
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.nasa.domain.entity.RepositoryNasa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelNasa : ViewModel() {

    private val repository: RepositoryNasa by Injector.inject()

    private val _state = MutableStateFlow(NasaPostsState())
    val state = _state.asStateFlow()

    init {
        loadAllPosts()
    }

    fun loadAllPosts() {
        loadLastApod()
        loadLastPostTechTransfer()
        loadAsteroids()
    }


    private fun loadAsteroids() {
        viewModelScope.launch {
            _state.reduce {
                it.copy(isLoadingPostAsteroids = true)
            }
            val post = repository.loadAsteroids()
            val lastPost = post.lastOrNull()
            _state.reduce {
                it.copy(postsAsteroids = lastPost)
            }
        }.invokeOnCompletion { throwable ->
            _state.reduce {
                it.copy(isLoadingPostAsteroids = false, isError = throwable.isError)
            }
        }
    }

    private fun loadLastPostTechTransfer() {
        viewModelScope.launch {
            _state.reduce {
                it.copy(isLoadingPostTechTransfer = true)
            }
            val post = repository.loadTechTransfer()
            val lastPost = post.lastOrNull()
            _state.reduce {
                it.copy(postsTechTransfer = lastPost)
            }
        }.invokeOnCompletion { throwable ->
            _state.reduce {
                it.copy(isLoadingPostTechTransfer = false, isError = throwable.isError)
            }
        }
    }

    private fun loadLastApod() {
        viewModelScope.launch {
            _state.reduce {
                it.copy(isLoadingPostApod = true)
            }
            val post = repository.loadApod()
            _state.reduce {
                it.copy(postsApod = post)
            }
        }.invokeOnCompletion { throwable ->
            _state.reduce {
                it.copy(isLoadingPostApod = false, isError = throwable.isError)
            }
        }
    }
}