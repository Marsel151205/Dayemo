package com.marsel.dayemo.presentation.features.addnewemotion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.marsel.dayemo.R
import com.marsel.dayemo.presentation.utils.appbar.CustomAppBar

@Composable
fun AddNewEmotionScreen(
    navHostController: NavHostController
) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(colorResource(id = R.color.background_black))
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {

        CustomAppBar(
            appBarTitle = "Ваше настроение",
            leftIcon = R.drawable.ic_home_back,
            rightIcon = null,
            onLeftIconClick = { navHostController.popBackStack() },
            onRightIconClick = { TODO() }
        )


    }
}