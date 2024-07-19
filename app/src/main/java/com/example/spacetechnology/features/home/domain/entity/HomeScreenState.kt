package com.example.spacetechnology.features.home.domain.entity

sealed class HomeScreenState {

    data object InitialState : HomeScreenState()

    data object HomeState : HomeScreenState()

    data object NasaState : HomeScreenState()

    data object SpacexState : HomeScreenState()

    data object ProfileState : HomeScreenState()

}