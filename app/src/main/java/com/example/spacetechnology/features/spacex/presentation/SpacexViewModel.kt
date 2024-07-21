package com.example.spacetechnology.features.spacex.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.features.spacex.data.mapper.mapperSpacexDragon
import com.example.spacetechnology.features.spacex.data.network.ApiFactorySpacex
import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SpacexViewModel : ViewModel() {

    private val _postDragons = MutableStateFlow<List<SpacexDragon>>(listOf())
    val postDragon = _postDragons.asStateFlow()

    init {
        loadDragonPosts()
    }

    private fun loadDragonPosts() {
        viewModelScope.launch {
            val response = ApiFactorySpacex.apiService.getDragon()
            val dragons = mapperSpacexDragon(response)
            _postDragons.value = dragons
        }
    }
}