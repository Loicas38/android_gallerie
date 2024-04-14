package com.example.gallerie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.gallerie.data.Datasource
import com.example.gallerie.data.RecordData
import com.example.gallerie.model.DisplayMode
import com.example.gallerie.model.Picture


@Composable
fun MainPicturesGrid(data: RecordData) {
    Scaffold(
        topBar = {
            PicturesGridTopAppBar(
                data
            )
        }
    ) {
        PicturesGrid(data = data, space = it)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PicturesGridTopAppBar(data: RecordData) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                stringResource(data.GalleryObject.galleryName),
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .clickable {
                        data.mode = DisplayMode.PICTURES_GRID
                    }
            )
        }
    )
}


@Composable
fun PicturesGrid(data: RecordData, space: PaddingValues, modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 8.dp,
        contentPadding = space,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {

            items(RecordData.GalleryObject.picturesList) { photo ->
                Card(
                    shape = RoundedCornerShape(0.dp)
                ) {

                    Image(
                        painterResource(photo.pictureResourceId),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(RoundedCornerShape(0.dp))
                            .clickable {
                                data.mode = DisplayMode.PICTURE_DETAILS;
                                data.DetailedPicture = photo
                            }
                    )


                }

            }
        },
        modifier = Modifier
            .padding(8.dp)
    )
}
