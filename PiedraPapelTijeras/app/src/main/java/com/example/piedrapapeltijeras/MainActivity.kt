package com.example.piedrapapeltijeras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.piedrapapeltijeras.ui.theme.PiedraPapelTijerasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PiedraPapelTijerasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    tableroJuego()
                }
            }
        }
    }
}

@Composable
fun tableroJuego(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Row(
            modifier.weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.piedra),
                    contentDescription = "Piedra",
                    modifier = modifier
                        .size(100.dp)
                )
                Text(
                    text = "Piedra",
                    modifier = modifier.padding(5.dp)
                )
            }
            Column(
                modifier = modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.papel),
                    contentDescription = "Papel",
                    modifier = modifier
                        .size(100.dp)
                )
                Text(
                    text = "Papel",
                    modifier = modifier.padding(5.dp)
                )
            }
            Column(
                modifier = modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tijeras),
                    contentDescription = "Tijeras",
                    modifier = modifier
                        .size(100.dp)
                )
                Text(
                    text = "Tijeras",
                    modifier = modifier.padding(5.dp)
                )
            }
        }

        Row(
            modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "HOLA")
        }

        Row(
            modifier.weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.piedra),
                    contentDescription = "Piedra",
                    modifier = modifier
                        .size(100.dp)
                )
                Text(
                    text = "Piedra",
                    modifier = modifier.padding(5.dp)
                )
            }
            Column(
                modifier = modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.papel),
                    contentDescription = "Papel",
                    modifier = modifier
                        .size(100.dp)
                )
                Text(
                    text = "Papel",
                    modifier = modifier.padding(5.dp)
                )
            }
            Column(
                modifier = modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tijeras),
                    contentDescription = "Tijeras",
                    modifier = modifier
                        .size(100.dp)
                )
                Text(
                    text = "Tijeras",
                    modifier = modifier.padding(5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PiedraPapelTijerasTheme {
        tableroJuego()
    }
}