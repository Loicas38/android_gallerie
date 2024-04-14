package com.example.gallerie.data

import androidx.annotation.DrawableRes
import com.example.gallerie.model.DisplayMode
import com.example.gallerie.model.Gallery
import com.example.gallerie.model.Picture

object RecordData {
    // to record the current mode of display
    var mode: DisplayMode = DisplayMode.GALLERIES_GRID
    //the sungle picture to display
    var DetailedPicture: Picture = Datasource().loadPictures()[0]
    // the gallery to display
    var GalleryObject: Gallery = Datasource().loadGalleries()[0]
}