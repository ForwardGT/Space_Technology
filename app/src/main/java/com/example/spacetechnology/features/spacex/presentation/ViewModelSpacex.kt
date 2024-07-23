package com.example.spacetechnology.features.spacex.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.core.utils.extensions.isError
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
        loadAllPost()
    }

    fun loadAllPost() {
        loadDragons()
        loadRocket()
        loadLandPads()
    }

    private fun loadDragons() {
        viewModelScope.launch {
            _state.reduce {
                it.copy(isLoadingDragon = true)
            }
            val posts = repository.loadDragon()
            val lastPost = posts.lastOrNull()
            _state.reduce {
                it.copy(postDragon = lastPost)
            }
            _state.reduce {
                it.copy(loadingStateSpacexPosts = _state.value.loadingStateSpacexPosts + 1)
            }
        }.invokeOnCompletion { throwError ->
            _state.reduce {
                it.copy(isLoadingDragon = false, isError = throwError.isError)
            }
        }
    }

    private fun loadRocket() {
        viewModelScope.launch {
            _state.reduce {
                it.copy(isLoadingRockets = true)
            }
            val posts = repository.loadRocket()
            val lastPost = posts.lastOrNull()
            _state.reduce {
                it.copy(postRocket = lastPost)
            }
            _state.reduce {
                it.copy(loadingStateSpacexPosts = _state.value.loadingStateSpacexPosts + 1)
            }
        }.invokeOnCompletion { throwError ->
            _state.reduce {
                it.copy(isLoadingRockets = false, isError = throwError.isError)
            }
        }
    }

    private fun loadLandPads() {
        viewModelScope.launch {
            _state.reduce {
                it.copy(isLoadingLandPads = true)
            }
            val posts = repository.loadLandPads()
            val lastPost = posts.lastOrNull()
            _state.reduce {
                it.copy(postLandPads = lastPost)
            }
            _state.reduce {
                it.copy(loadingStateSpacexPosts = _state.value.loadingStateSpacexPosts + 1)
            }
        }.invokeOnCompletion { throwError ->
            _state.reduce {
                it.copy(isLoadingLandPads = false, isError = throwError.isError)
            }
        }
    }
}