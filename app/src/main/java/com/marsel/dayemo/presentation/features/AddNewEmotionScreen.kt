package com.marsel.dayemo.presentation.features

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.marsel.dayemo.R

@Composable
fun AddNewEmotionScreen(
    navHostController: NavHostController
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "AddNewEmotionScreen",
            color = colorResource(R.color.black),
            fontSize = 18.sp
        )
    }
}