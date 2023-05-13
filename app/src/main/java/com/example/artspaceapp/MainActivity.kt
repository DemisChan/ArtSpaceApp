package com.example.artspaceapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ImageArtAndDescription(
    image: Int,
    title: Int,
    artist: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Art Piece",
            modifier = modifier
                .border(BorderStroke(1.dp, Color.Black))
                .background(Color.White)
                .padding(10.dp)
                .shadow(10.dp)
                .weight(0.7f, false),
        )
        Card(
            modifier = modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 20.dp)
                .align(Alignment.CenterHorizontally),
            elevation = 6.dp,) {
            Text(
                text = stringResource(id = title),
                fontSize = 24.sp,
                color = Color.DarkGray,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(4.dp)

            )
        }
        Surface(
            border = BorderStroke(1.dp, Color.Gray),
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(2.dp),
            elevation = 5.dp,
            color = Color.LightGray

        ) {
            Text(
                text = stringResource(id = artist),
                fontSize = 12.sp,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(4.dp)
            )
        }
    }
}

@Composable
fun NextButton(click: Int) {
    Button(
        onClick = { click },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(4.dp)
            .width(100.dp)
    ) {
        Text(text = "Next")
    }
}

@Composable
fun PreviousButton(click: Int) {
    Button(
        onClick = { click },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(4.dp)
            .width(100.dp)
    ) {
        Text(text = "Previous")
    }
}


@Composable
fun ArtSpaceApp(
) {
    var click by remember { mutableStateOf(0) }
    when (click) {
        0 -> ImageArtAndDescription(
            image = R.drawable.monalisa,
            title = R.string.mona_lisa,
            artist = R.string.Leonardo_da_Vinci
        )

        1 -> ImageArtAndDescription(
            image = R.drawable.starrynight,
            title = R.string.starry_night,
            artist = R.string.Vincent_van_Gogh
        )

        2 -> ImageArtAndDescription(
            image = R.drawable.bapismofchrist,
            title = R.string.christ_baptism,
            artist = R.string.Andrea_del_Verrocchio
        )

        else -> ImageArtAndDescription(
            image = R.drawable.the_persistence_of_memory,
            title = R.string.the_persistence_of_memory,
            artist = R.string.Salvador_dali
        )
    }

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .padding(bottom = 50.dp)
    ) {
        PreviousButton(click--)
        NextButton(click++)
        Log.d("++++++++++++++++++++++", "$click")
    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    ArtSpaceAppTheme {
        ImageArtAndDescription(
            image = R.drawable.monalisa,
            title = R.string.mona_lisa,
            artist = R.string.Leonardo_da_Vinci
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        PreviousButton(1)
        NextButton(1)
    }
}

