package com.example.gallerie


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.gallerie.data.RecordData
import com.example.gallerie.model.DisplayMode
import com.example.gallerie.ui.theme.GallerieTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GallerieTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GalleryApp()
                }
            }
        }
    }
}


@Composable
fun GalleryApp() {


    when (RecordData.mode) {
        DisplayMode.GALLERIES_GRID -> MainGalleriesGrid(RecordData)
        DisplayMode.PICTURES_GRID -> MainPicturesGrid(RecordData)
        DisplayMode.PICTURE_DETAILS -> MainPictureDetails(RecordData)
    }

}
