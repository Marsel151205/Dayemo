package com.marsel.dayemo.presentation.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marsel.dayemo.R
import com.marsel.dayemo.presentation.models.EmotionModel
import com.marsel.dayemo.presentation.utils.textstyle.StapelFontFamily

@Composable
fun EmotionRow(
    modifier: Modifier,
    onClickItem: (model: EmotionModel) -> Unit
) {

    val emotionList = listOf(
        EmotionModel(R.drawable.ic_green_emotion, "Супер", R.color.green),
        EmotionModel(R.drawable.ic_salad_emotion, "Хорошо", R.color.salad),
        EmotionModel(R.drawable.ic_yellow_emotion, "Так себе", R.color.yellow),
        EmotionModel(R.drawable.ic_orange_emotion, "Плохо", R.color.orange),
        EmotionModel(R.drawable.ic_red_emotion, "Ужасно", R.color.red)
    )

    Row(
        modifier = modifier
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        emotionList.forEach { item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable {
                        onClickItem(item)
                    }
            ) {
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = "Mood Icon",
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )

                Text(
                    text = item.label,
                    color = colorResource(item.labelColor),
                    fontSize = 14.sp,
                    fontFamily = StapelFontFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
            }
        }
    }
}