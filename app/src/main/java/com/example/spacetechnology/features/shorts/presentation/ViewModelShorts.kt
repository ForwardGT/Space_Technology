package com.example.spacetechnology.features.shorts.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.core.utils.extensions.reduce
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelShorts : ViewModel() {
    private val _state = MutableStateFlow(ShortsState())
    val state = _state.asStateFlow()

    fun launchScrollNextPage(totalPages: Int, currentPageIndex: Int) {

        viewModelScope.launch {

            launchFillProgressIndicator(currentPageIndex)

            if (_state.value.currentPage < totalPages) {
                _state.reduce { pagerState ->
                    pagerState.copy(
                        currentPage = (_state.value.currentPage + 1) % totalPages
                    )
                }
            }

            if (currentPageIndex == totalPages - 1) restartShorts()
        }
    }

    private suspend fun launchFillProgressIndicator(currentPageIndex: Int) {
        while (_state.value.shortElements[currentPageIndex].currentProgressIndicator < 1f) {
            val updatedShortElements =
                _state.value.shortElements.mapIndexed { index, shortElement ->
                    if (index == currentPageIndex) {
                        shortElement.copy(
                            currentProgressIndicator =
                            _state.value.shortElements[currentPageIndex].currentProgressIndicator + 0.025f
                        )
                    } else shortElement
                }

            _state.reduce { pagerState ->
                pagerState.copy(
                    shortElements = updatedShortElements
                )
            }
            delay(timeMillis = _state.value.currentSpeedRewind)
        }
    }

    private fun restartShorts() {
        _state.reduce { pagerState ->

            val resetShortElement =
                _state.value.shortElements.map {
                    it.copy(
                        currentProgressIndicator = 0f
                    )
                }

            pagerState.copy(
                shortElements = resetShortElement
            )

        }
        _state.reduce { pagerState ->
            pagerState.copy(
                currentPage = 0
            )
        }
    }

    fun rewind(press: Boolean = false) {
        if (press) {
            _state.reduce {
                it.copy(
                    currentSpeedRewind = 25,
                    rewindIconShow = true
                )
            }
        } else
            _state.reduce {
                it.copy(
                    currentSpeedRewind = 100,
                    rewindIconShow = false
                )
            }
    }
}