package com.example.spacetechnology.features.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.R
import com.example.spacetechnology.core.ui.entity.SpacexPostCrew
import com.example.spacetechnology.core.ui.entity.SpacexPostDragon
import com.example.spacetechnology.core.ui.entity.SpacexPostRocket
import com.example.spacetechnology.core.ui.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.core.ui.theme.SpaceTechnologyTheme
import com.example.spacetechnology.features.home.presentation.view.SpaceTechTopBar

@Composable
fun HomeScreen(
    navController: NavController
) {

    Scaffold(
        topBar = {
            SpaceTechTopBar()
        },
        bottomBar = {
            SpaceTechNavigationBar(navController)
        }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(top = 10.dp)
        ) {

            CardsSpacex()

            CardsSpacex()

        }
    }
}


@Composable
fun CardsSpacex() {

    val crew = SpacexPostCrew()
    val dragon = SpacexPostDragon()
    val rocket = SpacexPostRocket()

    LazyRow {
        item {
            OneCard(
                imagePreview = R.drawable.astronavt_preview,
                description = crew.description
            )
        }
        item {
            OneCard(
                imagePreview = R.drawable.dragon_preview,
                description = dragon.description
            )
        }
        item {
            OneCard(
                imagePreview = R.drawable.roket_preview,
                description = rocket.description
            )
        }
    }
}


@Composable
fun OneCard(
    imagePreview: Int,
    description: String
) {

    val viewWidth = with(LocalDensity.current) {
        LocalView.current.rootView.width.toDp()
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .width(viewWidth)
    ) {
        Image(
            painter = painterResource(id = imagePreview),
            alignment = Alignment.Center,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )
        Text(
            maxLines = 2,
            text = description,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
private fun P() {
    SpaceTechnologyTheme(true) {
        HomeScreen(navController = rememberNavController())
    }
}