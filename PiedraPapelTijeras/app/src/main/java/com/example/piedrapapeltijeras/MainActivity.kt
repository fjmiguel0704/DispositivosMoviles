package com.example.piedrapapeltijeras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
val listaImagenes = listOf(
    R.drawable.piedra,
    R.drawable.papel,
    R.drawable.tijeras
)

@Composable
fun tableroJuego(modifier: Modifier = Modifier) {
    var cambioImagenJ1 by remember{ mutableStateOf(0) }
    var cambioImagenMaquina by remember{ mutableStateOf(0) }
    var puntuacionJ1 by remember { mutableStateOf(0) }
    var puntuacionMaquina by remember { mutableStateOf(0) }

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
            modifier.weight(1f)
        ) {
            Column(modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = listaImagenes[cambioImagenMaquina]),
                    contentDescription = "tiradaMáquina")
            }
        }

        Row (
            modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = puntuacionJ1.toString())
            }

            Column {
                Image(painter = painterResource(id = R.drawable.vs)
                    , contentDescription = "imageVS",
                    modifier
                        .size(200.dp))
            }

            Column {
                Text(text = puntuacionMaquina.toString())
            }
        }

        Row(
            modifier.weight(1f)
        ) {
            Column(modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = listaImagenes[cambioImagenJ1]),
                    contentDescription = "tiradaJugador1")
            }
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
                        .clickable {
                            cambioImagenJ1 = 0

                            cambioImagenMaquina = getTiradaMaquina()

                            puntuacionJ1 += calculaPuntuacionJ1(cambioImagenJ1, cambioImagenMaquina)
                            puntuacionMaquina += calculaPuntuacionMaquina(cambioImagenJ1, cambioImagenMaquina)
                        }
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
                    modifier
                        .size(100.dp)
                        .clickable {
                            cambioImagenJ1 = 1

                            cambioImagenMaquina = getTiradaMaquina()

                            puntuacionJ1 += calculaPuntuacionJ1(cambioImagenJ1, cambioImagenMaquina)
                            puntuacionMaquina += calculaPuntuacionMaquina(cambioImagenJ1, cambioImagenMaquina)
                        }
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
                        .clickable {
                            cambioImagenJ1 = 2

                            cambioImagenMaquina = getTiradaMaquina()

                            puntuacionJ1 += calculaPuntuacionJ1(cambioImagenJ1, cambioImagenMaquina)
                            puntuacionMaquina += calculaPuntuacionMaquina(cambioImagenJ1, cambioImagenMaquina)
                        }
                )
                Text(
                    text = "Tijeras",
                    modifier = modifier.padding(5.dp)
                )
            }
        }
    }
}

fun getTiradaMaquina(): Int {
return (0..2).random()
}

fun calculaPuntuacionJ1(tiradaJ1:Int, tiradaMaquina: Int):Int{
    var puntuacionJ1: Int = 0
    var puntuacionMaquina: Int = 0
    if (tiradaJ1 == 0 && tiradaMaquina == 2){
        puntuacionJ1=1
        puntuacionMaquina=0
    } else if (tiradaJ1 == 1 && tiradaMaquina == 0) {
        puntuacionJ1=1
        puntuacionMaquina=0
    } else if (tiradaJ1 == 2 && tiradaMaquina == 1) {
        puntuacionJ1=1
        puntuacionMaquina=0
    } else {
        puntuacionJ1=0
        puntuacionMaquina=0
    }

    return puntuacionJ1
}

fun calculaPuntuacionMaquina(tiradaJ1:Int, tiradaMaquina: Int):Int{
    var puntuacionJ1: Int = 0
    var puntuacionMaquina: Int = 0

    if (tiradaJ1==0 && tiradaMaquina == 1){
        puntuacionJ1=0
        puntuacionMaquina=1
    } else if (tiradaJ1 == 1 && tiradaMaquina == 2) {
        puntuacionJ1=0
        puntuacionMaquina=1
    } else if (tiradaJ1 == 2 && tiradaMaquina == 0) {
        puntuacionJ1=0
        puntuacionMaquina=1
    }  else {
        puntuacionJ1=0
        puntuacionMaquina=0
    }

    return puntuacionMaquina
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PiedraPapelTijerasTheme {
        tableroJuego()
    }
}