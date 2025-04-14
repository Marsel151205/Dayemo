package com.marsel.dayemo.presentation.features.add_emotion.details

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
import com.marsel.dayemo.presentation.models.EmotionModel
import com.marsel.dayemo.presentation.utils.appbar.CustomAppBar
import timber.log.Timber

@Composable
fun AddEmotionDetail(
    navHostController: NavHostController,
    emotionModel: EmotionModel
) {

    Column(
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxSize()
            .background(colorResource(R.color.background_black)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        CustomAppBar(
            appBarTitle = "Опишите ваш день",
            leftIcon = R.drawable.ic_home_back,
            rightIcon = R.drawable.ic_done,
            onLeftIconClick = { navHostController.popBackStack() },
            onRightIconClick = { TODO() },
            modifier = Modifier
        )

//        Timber.tag("emotionCheck").d(emotionModel.label)
    }
}