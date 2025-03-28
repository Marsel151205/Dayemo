package com.marsel.dayemo.presentation.features.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.marsel.dayemo.R
import com.marsel.dayemo.presentation.utils.appbar.CustomAppBar
import com.marsel.dayemo.presentation.utils.error.ErrorItem

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {

    val emotionList = rememberLazyListState()
    var isEmpty by remember { mutableStateOf(false) }
    val itemList = listOf<String>()

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(colorResource(R.color.background_black))
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {

        CustomAppBar(
            appBarTitle = "Март 2025",
            leftIcon = R.drawable.ic_home_back,
            rightIcon = R.drawable.ic_home_next,
            onLeftIconClick = { Log.e("clickLeftIcon", "true") },
            onRightIconClick = { Log.e("clickRightIcon", "true") },
            modifier = Modifier
        )
        LaunchedEffect(emotionList) {
            isEmpty = emotionList.layoutInfo.totalItemsCount == 0
        }
        Log.e("isEmpty", isEmpty.toString())

        if (itemList.isEmpty()) {
            Spacer(modifier = Modifier.weight(0.7f))
            ErrorItem(
                errorIcon = R.drawable.empty_note,
                errorTitle = "Записки отсуствуют",
                titleSize = 18,
                titleColor = R.color.disable_navigation_bar_item
            )
            Spacer(modifier = Modifier.weight(1f))
        } else {
            LazyColumn(
                state = emotionList,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                items(itemList.size) { index ->
                    Text(
                        text = itemList[index],
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}
