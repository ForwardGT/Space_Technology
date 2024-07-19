package com.example.spacetechnology.features.home.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _screenState = MutableStateFlow<NavigationItem>(NavigationItem.Home)
    var screenState = _screenState.asStateFlow()


    fun changeScreenState(item: NavigationItem) {
        _screenState.value = item
    }
}