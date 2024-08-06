package com.example.spacetechnology

import android.app.Application
import android.content.Context
import com.example.spacetechnology.features.auth.domain.DataStore
import com.example.spacetechnology.features.auth.presentation.ViewModelAuth
import com.example.spacetechnology.features.home.presentation.ViewModelHome
import com.example.spacetechnology.features.nasa.data.repository.RepositoryNasaImpl
import com.example.spacetechnology.features.nasa.domain.entity.RepositoryNasa
import com.example.spacetechnology.features.nasa.presentation.ViewModelNasa
import com.example.spacetechnology.features.profile.presentation.ViewModelProfile
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
                viewModelHome,
                viewModelSpacex,
                viewModelNasa,
                viewModelAuth,
                viewModelProfile,
                repositorySpacex,
                repositoryNasa,
                dataStore
            )
        }
    }
}

private val viewModelHome = module {
    viewModel { ViewModelHome() }
}

private val viewModelSpacex = module {
    viewModel { ViewModelSpacex() }
}

private val viewModelNasa = module {
    viewModel { ViewModelNasa() }
}

private val viewModelAuth = module {
    viewModel { ViewModelAuth() }
}

private val viewModelProfile = module {
    viewModel { ViewModelProfile() }
}

private val repositorySpacex = module {
    single<RepositorySpacex> { RepositorySpacexImpl() }
}

private val repositoryNasa = module {
    single<RepositoryNasa> { RepositoryNasaImpl() }
}

private val dataStore = module {
    single { DataStore(get<Context>()) }
}