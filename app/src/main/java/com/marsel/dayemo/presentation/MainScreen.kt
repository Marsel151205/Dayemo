package com.marsel.dayemo.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.marsel.dayemo.R
import com.marsel.dayemo.presentation.utils.navigation.NavigationItem
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marsel.dayemo.presentation.features.AddNewEmotionScreen
import com.marsel.dayemo.presentation.features.CalendarScreen
import com.marsel.dayemo.presentation.features.HomeScreen
import com.marsel.dayemo.presentation.features.SettingsScreen
import com.marsel.dayemo.presentation.features.StatisticsScreen
import com.marsel.dayemo.tools.NavigationRoute

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()

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

    Scaffold(
        Modifier.fillMaxWidth(),
        bottomBar = {
            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                NavigationBar(
                    containerColor = colorResource(R.color.middle_gray),
                    modifier = Modifier
                        .blur(50.dp)
                        .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
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
                                )
                            },
                            Modifier
                                .height(19.dp)
                                .width(19.dp)
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