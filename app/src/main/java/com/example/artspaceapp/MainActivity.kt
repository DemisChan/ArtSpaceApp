package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
                    ArtSpaceScreen()
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
    modifier: Modifier = Modifier) {
    Column() {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Art Piece",
            modifier = modifier
        )
        Text(
            text = stringResource(id = title),
            fontSize = 24.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)

        )
        Text(
            text = stringResource(id = artist),
            fontSize = 12.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)

        )


    }
}





@Composable
fun ArtSpaceScreen() {

}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    ArtSpaceAppTheme {
        ImageArtAndDescription(
            image = R.drawable.monalisa,
            title = R.string.mona_lisa,
            artist = R.string.mona_lisa
        )
    }
}