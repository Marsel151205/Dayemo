package com.marsel.dayemo.presentation.utils.navigation

import androidx.annotation.DrawableRes
import com.marsel.dayemo.R
import com.marsel.dayemo.tools.NavigationRoute

sealed class NavigationItem(
    var route: String,
    @DrawableRes val icon: Int,
) {

    data object Home: NavigationItem(
        NavigationRoute.HOME.route,
        R.drawable.ic_smile
    )

    data object Statistics: NavigationItem(
        NavigationRoute.STATISTICS.route,
        R.drawable.ic_statistics
    )

    data object Add: NavigationItem(
        NavigationRoute.ADD.route,
        R.drawable.ic_plus
    )

    data object Calendar: NavigationItem(
        NavigationRoute.CALENDAR.route,
        R.drawable.ic_calendar
    )

    data object Settings: NavigationItem(
        NavigationRoute.SETTINGS.route,
        R.drawable.ic_settings
    )
}