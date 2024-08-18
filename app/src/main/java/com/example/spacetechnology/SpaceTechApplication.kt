package com.example.spacetechnology

import android.app.Application
import android.content.Context
import com.example.spacetechnology.cache.CacheFactory
import com.example.spacetechnology.cache.CacheFactoryImpl
import com.example.spacetechnology.dao.DataStore
import com.example.spacetechnology.features.auth.presentation.ViewModelAuth
import com.example.spacetechnology.features.home.presentation.ViewModelHome
import com.example.spacetechnology.features.my_posts.presentation.ViewModelCreateMyPostScreen
import com.example.spacetechnology.features.nasa.data.network.ApiServiceKtorNasa
import com.example.spacetechnology.features.nasa.data.repository.RepositoryNasaImpl
import com.example.spacetechnology.features.nasa.domain.entity.RepositoryNasa
import com.example.spacetechnology.features.nasa.presentation.ViewModelNasa
import com.example.spacetechnology.features.profile.presentation.ViewModelProfile
import com.example.spacetechnology.features.spacex.data.network.ApiServiceKtorSpacex
import com.example.spacetechnology.features.spacex.data.repository.RepositorySpacexImpl
import com.example.spacetechnology.features.spacex.domain.RepositorySpacex
import com.example.spacetechnology.features.spacex.presentation.ViewModelSpacex
import com.example.spacetechnology.notification.createNotificationChannels
import com.example.spacetechnology.notification.getTokenFromNotification
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
        getTokenFromNotification()
        createNotificationChannels(applicationContext)

        startKoin {

            androidContext(this@SpaceTechApplication)

            modules(
                viewModels,
                repository,
                dataStore,
                cache,
                apiServices,
            )
        }
    }
}


private val viewModels = module {
    viewModel { ViewModelHome() }
    viewModel { ViewModelNasa() }
    viewModel { ViewModelAuth() }
    viewModel { ViewModelSpacex() }
    viewModel { ViewModelProfile() }
    viewModel { ViewModelCreateMyPostScreen() }
}

private val repository = module {
    single<RepositorySpacex> { RepositorySpacexImpl() }
    single<RepositoryNasa> { RepositoryNasaImpl() }
}

private val dataStore = module {
    single { DataStore(get<Context>()) }
}

private val cache = module {
    single<CacheFactory> { CacheFactoryImpl() }
}

private val apiServices = module {
    single { ApiServiceKtorNasa() }
    single { ApiServiceKtorSpacex() }
}
