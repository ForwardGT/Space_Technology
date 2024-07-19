package com.example.spacetechnology

import android.app.Application
import com.example.spacetechnology.features.home.presentation.HomeViewModel
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
                homeScreenViewModel
            )
        }
    }
}

val homeScreenViewModel = module {
    viewModel { HomeViewModel() }
}