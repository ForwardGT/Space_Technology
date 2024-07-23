package com.example.spacetechnology.features.spacex.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.core.utils.extensions.reduce
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.spacex.domain.RepositorySpacex
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelSpacex : ViewModel() {

    private val repository: RepositorySpacex by Injector.inject()

    private val _state = MutableStateFlow(SpacexPostsState())
    val state = _state.asStateFlow()

    init {
        loadDragons()
        loadRocket()
        loadLandPads()
    }

    fun loadDragons() {
        viewModelScope.launch {
            _state.reduce {
                it.copy(isLoading = true)
            }
            val posts = repository.loadDragon()
            val lastPost = posts.lastOrNull()
            _state.reduce {
                it.copy(isLoading = false, postDragon = lastPost)
            }
            _state.reduce {
                it.copy(loadingStateSpacexPosts = _state.value.loadingStateSpacexPosts + 1)
            }
        }.invokeOnCompletion {
            _state.reduce {
                it.copy(isLoading = false, isError = it.isError)
            }
        }
    }

    fun loadRocket() {
        viewModelScope.launch {
            val posts = repository.loadRocket()
            val lastPost = posts.lastOrNull()
            _state.reduce {
                it.copy(isLoading = true)
            }
            _state.reduce {
                it.copy(isLoading = false, postRocket = lastPost)
            }
            _state.reduce {
                it.copy(loadingStateSpacexPosts = _state.value.loadingStateSpacexPosts + 1)
            }
        }.invokeOnCompletion {
            _state.reduce {
                it.copy(isLoading = false, isError = it.isError)
            }
        }
    }

    fun loadLandPads() {
        viewModelScope.launch {
            val posts = repository.loadLandPads()
            val lastPost = posts.lastOrNull()
            _state.reduce {
                it.copy(isLoading = true)
            }
            _state.reduce {
                it.copy(isLoading = false, postLandPads = lastPost)
            }
            _state.reduce {
                it.copy(loadingStateSpacexPosts = _state.value.loadingStateSpacexPosts + 1)
            }
        }.invokeOnCompletion {
            _state.reduce {
                it.copy(isLoading = false, isError = it.isError)
            }
        }
    }
}