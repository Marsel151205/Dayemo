package com.marsel.dayemo.presentation.models

import java.io.Serializable

data class EmotionModel (
    val icon: Int,
    val label: String,
    val labelColor: Int
): Serializable