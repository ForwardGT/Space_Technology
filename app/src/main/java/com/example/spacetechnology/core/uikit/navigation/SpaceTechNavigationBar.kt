package com.example.spacetechnology.core.uikit.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.extensions.navigation.navigateTo
import com.example.spacetechnology.features.home.presentation.NavigationItem

@Composable
fun SpaceTechNavigationBar(
    navController: NavController
) {
    val barItem = listOf(
        NavigationItem.Home,
        NavigationItem.SpaceX,
        NavigationItem.Nasa,
        NavigationItem.MyPosts,
        NavigationItem.Profile,
        NavigationItem.MyShorts
    )

    NavigationBar(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            .background(SpaceTechColor.navigationElement, RoundedCornerShape(18.dp)),
        containerColor = Color.Transparent,

        content = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination


            barItem.forEach { item ->

                val selected = currentDestination?.hierarchy?.any {
                    it.route == item.screen.route
                } ?: false

                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    enabled = true,
                    onClick = { if (!selected) navController.navigateTo(item.screen.route) }
                ) {
                    Icon(
                        modifier = Modifier.size(26.dp),
                        imageVector = item.icon,
                        contentDescription = item.nameItem,
                        tint = if (selected) SpaceTechColor.white else SpaceTechColor.white.copy(alpha = 0.6f)
                    )
                }
            }
        }
    )
}