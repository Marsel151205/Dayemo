package com.marsel.dayemo.presentation.features.add_emotion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.marsel.dayemo.R
import com.marsel.dayemo.presentation.utils.EmotionRow
import com.marsel.dayemo.presentation.utils.appbar.CustomAppBar
import com.marsel.dayemo.tools.Screens

@Composable
fun AddNewEmotionScreen(
    navHostController: NavHostController
) {

    Box(
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
            onRightIconClick = { TODO() },
            modifier = Modifier
                .align(Alignment.TopStart)
        )

        EmotionRow(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            onClickItem = { model ->
                navHostController.navigate("${Screens.ADD_EMOTION_DETAIL.route}/$model")
            }
        )
    }
}