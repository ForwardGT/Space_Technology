package com.example.spacetechnology.features.home.domain.entity

import com.example.spacetechnology.R

object PostsForMainScreenBP {
    val spacexPosts = listOf(
        HomeScreenPostImpl(
            description = "Rockets SpaceX: Explore SpaceX's innovative designs and powerful launch vehicles.",
            imagePreview = R.drawable.rocket_preview,
            pathIcon = R.drawable.spacex_logo,
            pathUrl = "https://www.spacex.com"
        ),
        HomeScreenPostImpl(
            description = "Dragon spacecraft SpaceX: Learn about the revolutionary vessels for cargo and crewed missions",
            imagePreview = R.drawable.dragon_preview,
            pathIcon = R.drawable.spacex_logo,
            pathUrl = "https://www.spacex.com"
        ),
        HomeScreenPostImpl(
            description = "Landpad SpaceX: A designated platform for rocket landings, equipped with guiding markers and the SpaceX logo, often located on ocean barges or coastal sites.",
            imagePreview = R.drawable.landpads_preview,
            pathIcon = R.drawable.spacex_logo,
            pathUrl = "https://www.spacex.com"
        )
    )

    val nasaPosts = listOf(
        HomeScreenPostImpl(
            description = "Last news NASA: Catch up on today's top news and major world events",
            imagePreview = R.drawable.last_news_nasa,
            pathIcon = R.drawable.nasa_logo,
            pathUrl = "https://www.nasa.gov/"
        ),
        HomeScreenPostImpl(
            description = "Technologies NASA: Explore NASA's groundbreaking technologies transforming space and Earth.",
            imagePreview = R.drawable.tehnology_nasa,
            pathIcon = R.drawable.nasa_logo,
            pathUrl = "https://www.nasa.gov/"
        ),
        HomeScreenPostImpl(
            description = "Asteroids NASA: Uncover the secrets of asteroids: their origins, orbits, and potential Earth impacts.",
            imagePreview = R.drawable.asteroids_nasa,
            pathIcon = R.drawable.nasa_logo,
            pathUrl = "https://www.nasa.gov/"
        )
    )
}