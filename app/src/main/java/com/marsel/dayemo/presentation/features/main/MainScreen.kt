package com.marsel.dayemo.presentation.features.main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.marsel.dayemo.R
import com.marsel.dayemo.presentation.utils.navigation.NavigationItem
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marsel.dayemo.presentation.features.statistics.StatisticsScreen
import com.marsel.dayemo.presentation.features.addnewemotion.AddNewEmotionScreen
import com.marsel.dayemo.presentation.features.calendar.CalendarScreen
import com.marsel.dayemo.presentation.features.home.HomeScreen
import com.marsel.dayemo.presentation.features.settings.SettingsScreen
import com.marsel.dayemo.tools.NavigationRoute

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()
    var isNavigationBarVisible by remember { mutableStateOf(true) }

    val navigationItems = listOf(
        NavigationItem.Home,
        NavigationItem.Statistics,
        NavigationItem.Add,
        NavigationItem.Calendar,
        NavigationItem.Settings
    )

    val currentRoute = remember { mutableStateOf(NavigationRoute.HOME.route) }

    val selectedItem = remember { mutableStateOf(0) }

    navigationItems.forEachIndexed { index, navigationItem ->
        if (navigationItem.route == currentRoute.value) {
            selectedItem.value = index
        }
    }

    LaunchedEffect(key1 = navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            isNavigationBarVisible = when (backStackEntry.destination.route) {
                NavigationRoute.ADD.route -> false
                else -> true
            }
        }
    }

    Scaffold(
        Modifier.fillMaxWidth(),
        bottomBar = {
            if (isNavigationBarVisible) {
                NavigationBar(
                    containerColor = colorResource(R.color.middle_gray),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp)
                        .padding(bottom = 90.dp)
                        .clip(RoundedCornerShape(60.dp)),
                    windowInsets = WindowInsets(0.dp)
                ) {
                    navigationItems.forEachIndexed { index, navItem ->

                        val isSelected = index == selectedItem.value

                        this@NavigationBar.NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                selectedItem.value = index
                                currentRoute.value = navItem.route
                                navController.navigate(navItem.route) {
                                    navController.graph.startDestinationRoute?.let { route ->
                                        popUpTo(route) {
                                            saveState = true
                                        }
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Image(
                                    painter = painterResource(navItem.icon),
                                    contentDescription = "Icon",
                                    Modifier
                                        .size(30.dp)
                                )
                            },
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                                .padding(horizontal = 10.dp),

                            colors = NavigationBarItemColors(
                                selectedIconColor = colorResource(id = R.color.white),
                                selectedTextColor = colorResource(id = R.color.white),
                                selectedIndicatorColor = colorResource(id = R.color.transparent),
                                unselectedIconColor = colorResource(id = R.color.disable_navigation_bar_item),
                                unselectedTextColor = colorResource(id = R.color.disable_navigation_bar_item),
                                disabledIconColor = colorResource(id = R.color.disable_navigation_bar_item),
                                disabledTextColor = colorResource(id = R.color.disable_navigation_bar_item)
                            )
                        )
                    }
                }
            }
        }
    ) {
        ContentScreen(
            navHostController = navController
        )
    }
}

@Composable
fun ContentScreen(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = NavigationRoute.HOME.route
    ) {
        composable(
            NavigationRoute.HOME.route
        ) {
            HomeScreen(
                navHostController = navHostController
            )
        }

        composable(
            NavigationRoute.STATISTICS.route
        ) {
            StatisticsScreen(
                navHostController = navHostController
            )
        }

        composable(
            NavigationRoute.ADD.route
        ) {
            AddNewEmotionScreen(
                navHostController = navHostController
            )
        }

        composable(
            NavigationRoute.CALENDAR.route
        ) {
            CalendarScreen(
                navHostController = navHostController
            )
        }

        composable(
            NavigationRoute.SETTINGS.route
        ) {
            SettingsScreen(
                navHostController = navHostController
            )
        }
    }
}