package com.example.gallerie.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Picture(
    @StringRes val descriptionResourceId: Int,
    @DrawableRes val pictureResourceId: Int
)
