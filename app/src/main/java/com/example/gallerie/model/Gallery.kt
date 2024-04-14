package com.example.gallerie.model

import androidx.annotation.StringRes

data class Gallery(
    @StringRes val galleryName: Int,
    val picturesList: List<Picture>
)
