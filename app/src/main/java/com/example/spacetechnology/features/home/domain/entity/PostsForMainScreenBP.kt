package com.example.spacetechnology.features.home.domain.entity

import android.content.Context
import com.example.spacetechnology.R
import com.example.spacetechnology.core.utils.URL_NASA
import com.example.spacetechnology.core.utils.URL_SPACEX
import com.example.spacetechnology.di.Injector

object PostsForMainScreenBP {

    private val context: Context by Injector.inject()

    val spacexPosts = listOf(
        HomeScreenPostImpl(
            description = context.getString(R.string.rockets_spacex_explore),
            imagePreview = R.drawable.rocket_preview,
            pathIcon = R.drawable.spacex_logo,
            pathUrl = URL_SPACEX
        ),
        HomeScreenPostImpl(
            description = context.getString(R.string.dragon_spacecraft),
            imagePreview = R.drawable.dragon_preview,
            pathIcon = R.drawable.spacex_logo,
            pathUrl = URL_SPACEX
        ),
        HomeScreenPostImpl(
            description = context.getString(R.string.landpad_spacex),
            imagePreview = R.drawable.landpads_preview,
            pathIcon = R.drawable.spacex_logo,
            pathUrl = URL_SPACEX
        )
    )

    val nasaPosts = listOf(
        HomeScreenPostImpl(
            description = context.getString(R.string.last_news_nasa),
            imagePreview = R.drawable.last_news_nasa,
            pathIcon = R.drawable.nasa_logo,
            pathUrl = URL_NASA
        ),
        HomeScreenPostImpl(
            description = context.getString(R.string.technologies_nasa_explore_nasa),
            imagePreview = R.drawable.tehnology_nasa,
            pathIcon = R.drawable.nasa_logo,
            pathUrl = URL_NASA
        ),
        HomeScreenPostImpl(
            description = context.getString(R.string.asteroids_nasa_uncover),
            imagePreview = R.drawable.asteroids_nasa,
            pathIcon = R.drawable.nasa_logo,
            pathUrl = URL_NASA
        )
    )
}