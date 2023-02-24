package com.example.myaffirmationapplication.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringRsc: Int,
    @DrawableRes val imageRsc: Int,
)


