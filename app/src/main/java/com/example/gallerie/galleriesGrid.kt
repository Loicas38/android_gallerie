package com.example.gallerie

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.gallerie.data.Datasource
import com.example.gallerie.data.RecordData
import com.example.gallerie.model.DisplayMode

@Composable
fun MainGalleriesGrid(data: RecordData) {
    Scaffold (
        topBar = {
            GalleriesGridTopAppBar()
        }
    ){
        GalleriesGrid(data = data, it)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleriesGridTopAppBar() {
    var mode by remember {
        mutableStateOf(
            1
        )
    }
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.galleries_grid_top_app_bar),
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .clickable {
                        RecordData.mode = DisplayMode.GALLERIES_GRID
                        mode = 2
                    }
            )
        }
    )

    if (mode != 1){
        GalleryApp()
    }
}



@Composable
fun GalleriesGrid(data: RecordData, space: PaddingValues){
    var mode by remember { mutableStateOf(1) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = space,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.small_padding)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.small_padding)),
        modifier = Modifier
            .padding(
                start = dimensionResource(R.dimen.normal_padding),
                end = dimensionResource(R.dimen.normal_padding)
            )

    ) {
        items(Datasource().loadGalleries()){
            Box(
                modifier = Modifier.clickable {
                    data.mode = DisplayMode.PICTURES_GRID;
                    data.GalleryObject = it;
                    mode = 2
                }
            ){
                Image(
                    painter = painterResource(it.picturesList[0].pictureResourceId),
                    contentDescription = null
                )

                Text(
                    text = stringResource(it.galleryName),
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp),
                    style = MaterialTheme.typography.displaySmall,
                    color = Color(221, 247, 234, 255)
                )
            }
        }
    }

    if(mode != 1){
        GalleryApp()
    }
}