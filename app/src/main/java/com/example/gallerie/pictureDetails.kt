package com.example.gallerie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.gallerie.data.RecordData
import com.example.gallerie.model.DisplayMode


@Composable
fun MainPictureDetails(data: RecordData) {
    Scaffold (
        topBar = {
            PictureDetailsTopAppBar(data = data)
        }
    ){
        PictureDetails(data, it)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PictureDetailsTopAppBar(data: RecordData) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.picture_details_top_app_bar),
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(1f)
            )
        }
    )

}



@Composable
fun PictureDetails(data: RecordData, space: PaddingValues) {
    Column {
        Image(
            painterResource(data.DetailedPicture.pictureResourceId),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 100.dp, bottom = 50.dp)
                .fillMaxWidth(1f)
                .wrapContentSize(align = Alignment.Center)
                .clip(RoundedCornerShape(0.dp))
        )

        Text(
            text = stringResource(data.DetailedPicture.descriptionResourceId),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .background(
                    color = Color(33, 150, 243, 255),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(all = 30.dp)
        )

        Button(onClick = { data.mode = DisplayMode.PICTURES_GRID },

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
