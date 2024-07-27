package com.example.spacetechnology

import android.app.Application
import android.content.Context
import com.example.spacetechnology.features.auth.domain.DataStoreManager
import com.example.spacetechnology.features.auth.presentation.ViewModelRegistration
import com.example.spacetechnology.features.home.presentation.ViewModelHome
import com.example.spacetechnology.features.nasa.data.repository.RepositoryNasaImpl
import com.example.spacetechnology.features.nasa.domain.entity.RepositoryNasa
import com.example.spacetechnology.features.nasa.presentation.ViewModelNasa
import com.example.spacetechnology.features.spacex.data.repository.RepositorySpacexImpl
import com.example.spacetechnology.features.spacex.domain.RepositorySpacex
import com.example.spacetechnology.features.spacex.presentation.ViewModelSpacex
import io.github.aagrishankov.platform.PreRenderCurrentThemeStatusBars
import io.github.aagrishankov.platform.SystemThemeStatusBars
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class SpaceTechApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        PreRenderCurrentThemeStatusBars.activeTheme = SystemThemeStatusBars.DARK

        startKoin {

            androidContext(this@SpaceTechApplication)

            modules(
                homeScreenViewModel,
                spacexScreenViewModel,
                repositorySpacex,
                nasaScreenViewModel,
                repositoryNasa,
                registrationScreenViewModel,
                dataStore
            )
        }
    }
}

val homeScreenViewModel = module {
    viewModel { ViewModelHome() }
}

val spacexScreenViewModel = module {
    viewModel { ViewModelSpacex() }
}

val nasaScreenViewModel = module {
    viewModel { ViewModelNasa() }
}

val registrationScreenViewModel = module {
    viewModel { ViewModelRegistration() }
}

val repositorySpacex = module {
    single<RepositorySpacex> { RepositorySpacexImpl() }
}

val repositoryNasa = module {
    single<RepositoryNasa> { RepositoryNasaImpl() }
}

val dataStore = module {
    single { DataStoreManager(androidContext()) }
}