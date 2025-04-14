package com.marsel.dayemo.presentation.utils.navigation

import androidx.annotation.DrawableRes
import com.marsel.dayemo.R
import com.marsel.dayemo.tools.Screens

sealed class NavigationItem(
    var route: String,
    @DrawableRes val icon: Int,
) {

    data object Home: NavigationItem(
        Screens.HOME.route,
        R.drawable.ic_smile
    )

    data object Statistics: NavigationItem(
        Screens.STATISTICS.route,
        R.drawable.ic_statistics
    )

    data object Add: NavigationItem(
        Screens.ADD.route,
        R.drawable.ic_plus
    )

    data object Calendar: NavigationItem(
        Screens.CALENDAR.route,
        R.drawable.ic_calendar
    )

    data object Settings: NavigationItem(
        Screens.SETTINGS.route,
        R.drawable.ic_settings
    )
}