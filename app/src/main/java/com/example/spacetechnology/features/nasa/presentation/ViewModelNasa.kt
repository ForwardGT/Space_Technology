package com.example.spacetechnology.features.nasa.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.nasa.domain.entity.PostApodNasa
import com.example.spacetechnology.features.nasa.domain.entity.PostTechTransfer
import com.example.spacetechnology.features.nasa.domain.entity.RepositoryNasa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelNasa : ViewModel() {

    private val repository: RepositoryNasa by Injector.inject()

    private val _lastPostApod = MutableStateFlow(
        PostApodNasa(
            date = "",
            urlImage = "",
            explanation = "",
            title = ""
        )
    )
    val lastPostApod = _lastPostApod.asStateFlow()

    private val _lastPostTechTransfer = MutableStateFlow<List<PostTechTransfer>>(listOf())
    val lastPostTechTransfer = _lastPostTechTransfer.asStateFlow()


    init {
        loadLastApod()
        loadLastPostTechTransfer()
    }


    private fun loadLastPostTechTransfer() {
        viewModelScope.launch {
            val post = repository.loadTechTransfer()
            _lastPostTechTransfer.value = post
        }
    }

    private fun loadLastApod() {
        viewModelScope.launch {
            val post = repository.loadApod()
            _lastPostApod.value = post
        }
    }
}