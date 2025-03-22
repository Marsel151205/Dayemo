package com.marsel.dayemo.presentation.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.marsel.dayemo.R

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    Column(

        Modifier
            .background(colorResource(R.color.black))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "HomeScreen",
            color = colorResource(R.color.black),
            fontSize = 18.sp
        )
    }
}