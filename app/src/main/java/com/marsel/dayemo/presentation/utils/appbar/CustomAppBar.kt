package com.marsel.dayemo.presentation.utils.appbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marsel.dayemo.R
import com.marsel.dayemo.presentation.utils.textstyle.StapelFontFamily

@Composable
fun CustomAppBar(
    appBarTitle: String,
    leftIcon: Int?,
    rightIcon: Int?,
    onLeftIconClick: () -> Unit,
    onRightIconClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.transparent))
            .padding(horizontal = 20.dp)
    ) {

        leftIcon?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = "Left Icon",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .height(50.dp)
                    .width(50.dp)
                    .padding(4.dp)
                    .clickable {
                        onLeftIconClick()
                    }
            )
        }

        Text(
            text = appBarTitle,
            color = colorResource(id = R.color.white),
            fontSize = 18.sp,
            fontFamily = StapelFontFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .align(Alignment.Center)
        )

        rightIcon?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = " Right Icon",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .height(50.dp)
                    .width(50.dp)
                    .padding(4.dp)
                    .clickable {
                        onRightIconClick()
                    }
            )
        }
    }
}