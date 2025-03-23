package com.marsel.dayemo.presentation.utils.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
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
fun ErrorItem(
    errorIcon: Int,
    errorTitle: String,
    titleSize: Int
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = errorIcon),
            contentDescription = "Error Icon",
            modifier = Modifier
                .height(140.dp)
                .width(140.dp)
        )

        Text(
            text = errorTitle,
            color = colorResource(id = R.color.white),
            fontSize = titleSize.sp,
            fontFamily = StapelFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 10.dp)
        )
    }
}