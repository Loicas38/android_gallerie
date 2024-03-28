package com.example.gallerie


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gallerie.ui.theme.GallerieTheme
import com.example.gallerie.model.Picture
import com.example.gallerie.data.Datasource


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
                    GallerieApp()
                }
            }
        }
    }
}


@Composable
fun GallerieApp() {

    Scaffold(
        topBar = {
            GallerieTopAppBar()
        }
    ) { it ->

        val images = Datasource().loadPictures()
        PictureGrid(images = images, it)
    }

}


@Composable
fun GallerieTopAppBar() {
    Text(
        stringResource(R.string.topappbar),
        style = MaterialTheme.typography.displayLarge,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(1f)
    )
}


@Composable
fun PictureGrid(images: List<Picture>, space: PaddingValues = PaddingValues(0.dp), modifier: Modifier = Modifier) {
    var affichage by remember { mutableStateOf(1)}
    var grandeImage by remember { mutableStateOf(images[0]) }

    if (affichage == 1) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 8.dp,
            contentPadding = space,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(images) { photo ->
                    Card(shape = RoundedCornerShape(0.dp)) {
                        Button(onClick = { affichage = 2; grandeImage = photo },
                            modifier = Modifier
                                .fillMaxSize(1f)
                                .wrapContentSize(align = Alignment.Center, unbounded = false),
                            shape = RoundedCornerShape(0.dp)) {

                            Image(
                                painterResource(photo.pictureResourceId),
                                contentDescription = null,
                                modifier = Modifier

                                    .clip(RoundedCornerShape(0.dp))
                            )
                        }
                    }
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    } else {
        Column {
            Image(
                painterResource(grandeImage.pictureResourceId),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 100.dp, bottom = 50.dp)
                    .fillMaxWidth(1f)
                    .wrapContentSize(align=Alignment.Center)
                    .clip(RoundedCornerShape(0.dp))
            )

            Text(
                text = stringResource(grandeImage.descriptionResourceId),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(
                        color = Color(33, 150, 243, 255),
                        shape= RoundedCornerShape(20.dp)
                    )
                    .padding(all=30.dp)
            )

            Button(onClick = { affichage = 1 },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 30.dp)) {
                Text(
                    text="retour",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }


    }
    
}


@Composable
fun GrandeImage(image: Picture) {
    Image(
        painterResource(image.pictureResourceId),
        contentDescription = null,
        modifier = Modifier
            .fillMaxHeight(1f)
            .clip(RoundedCornerShape(0.dp))
    )
}


@Composable
fun PictureCard(image: Picture, modifier: Modifier = Modifier) {
    Card(shape = RoundedCornerShape(0.dp)) {
        Button(onClick = {  },
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(0.dp)) {

            Image(
                painterResource(image.pictureResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(1f)
                    .clip(RoundedCornerShape(0.dp))
                )
            }
        }

}


@Preview
@Composable
fun Preview() {
    val images = Datasource().loadPictures()
    PictureGrid(images = images)
}