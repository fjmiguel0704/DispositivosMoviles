package com.example.pruebacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pruebacompose.ui.theme.PruebaComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row {
        Column (
            modifier = modifier.padding(10.dp)
        ){
            Text(
                text = "Hello $name!",
                modifier = modifier,
                color = Color(223, 27, 159, 255)
            )
            Text(
                text = "Hello Junma!",
                modifier = modifier,
                color = Color(200, 101, 100, 200)
            )
        }

        Column (
            modifier = modifier.padding(10.dp)
        ){
            Text(
                text = "Hello Pepe!",
                modifier = modifier,
                color = Color(0, 10, 200, 200)

            )
            Text(
                text = "Hello Juan!",
                modifier = modifier,
                color = Color(60, 120, 200, 200)
            )
        }
    }

    Row (
        Modifier.padding(10.dp)
    ){
            AsyncImage(
                model="https://miro.medium.com/v2/resize:fit:720/format:webp/0*4ZPxpHss9DyBcHW8.png",
                contentDescription = "Compose",
                Modifier.size(300.dp, 300.dp)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PruebaComposeTheme {
        Greeting("Fernando")
    }
}