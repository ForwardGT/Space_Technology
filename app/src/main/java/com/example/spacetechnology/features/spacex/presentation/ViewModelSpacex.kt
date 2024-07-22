package com.example.spacetechnology.features.spacex.presentation

import android.util.Log
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

    private val _state = MutableStateFlow(SpacexDragonsPostsState())
    val state = _state.asStateFlow()

    init {
        loadDragons()
    }

    private fun loadDragons() {
        viewModelScope.launch {
            Log.d("TAG", "loadDragons: LAUNCH")
            _state.reduce {
                it.copy(isLoading = true)
            }
            val posts = repository.loadDragon()
            val lastPost = posts.lastOrNull()
            _state.reduce {
                it.copy(isLoading = false, post = lastPost)
            }
        }.invokeOnCompletion {
            _state.reduce {
                it.copy(isLoading = false, isError = it.isError)
            }
        }
    }
}