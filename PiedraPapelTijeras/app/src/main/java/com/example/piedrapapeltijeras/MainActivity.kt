package com.example.piedrapapeltijeras

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.example.piedrapapeltijeras.R.drawable.ppt
import com.example.piedrapapeltijeras.ui.theme.PiedraPapelTijerasTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PiedraPapelTijerasTheme {
                val navController = rememberNavController()

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
    var partidasJugadas by remember { mutableStateOf(0) }
    val context = LocalContext.current

    Column(modifier.fillMaxSize()) {
        Row(
            modifier
                .weight(1f)
                .background(color = Color(0xFFC5F9FE))
                .fillMaxSize(),
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
            modifier
                .weight(1f)
                .background(color = Color(0xFFE8EDEE))
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
                .background(color = Color(0xFFE8EDEE))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = puntuacionJ1.toString(),
                    fontSize = 40.sp)
            }

            Column {
                Image(painter = painterResource(id = R.drawable.vs)
                    , contentDescription = "imageVS",
                    modifier
                        .size(170.dp))
            }

            Column {
                Text(text = puntuacionMaquina.toString(),
                    fontSize = 40.sp)
            }
        }

        Row(
            modifier
                .weight(1f)
                .background(color = Color(0xFFE8EDEE))
        ) {
            Column(modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = listaImagenes[cambioImagenJ1]),
                    contentDescription = "tiradaJugador1")
            }
        }

        Row(
            modifier
                .weight(1f)
                .background(color = Color(0xFFF4CC95))
                .fillMaxSize(),
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
                            puntuacionMaquina += calculaPuntuacionMaquina(
                                cambioImagenJ1,
                                cambioImagenMaquina
                            )

                            if (calculaPuntuacionJ1(
                                    cambioImagenJ1,
                                    cambioImagenMaquina
                                ) > calculaPuntuacionMaquina(cambioImagenJ1, cambioImagenMaquina)
                            ) {
                                val toast = Toast
                                    .makeText(context, "¡Ganador J1!", Toast.LENGTH_SHORT)
                                    .show()
                            } else if (calculaPuntuacionMaquina(
                                    cambioImagenJ1,
                                    cambioImagenMaquina
                                ) > calculaPuntuacionJ1(cambioImagenJ1, cambioImagenMaquina)
                            ) {
                                val toast = Toast
                                    .makeText(context, "¡Ganador Máquina!", Toast.LENGTH_SHORT)
                                    .show()
                            } else {
                                val toast = Toast
                                    .makeText(context, "¡EMPATE!", Toast.LENGTH_SHORT)
                                    .show()
                            }

                            partidasJugadas += 1
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
                            puntuacionMaquina += calculaPuntuacionMaquina(
                                cambioImagenJ1,
                                cambioImagenMaquina
                            )

                            if (calculaPuntuacionJ1(
                                    cambioImagenJ1,
                                    cambioImagenMaquina
                                ) > calculaPuntuacionMaquina(cambioImagenJ1, cambioImagenMaquina)
                            ) {
                                val toast = Toast
                                    .makeText(context, "¡Ganador J1!", Toast.LENGTH_SHORT)
                                    .show()
                            } else if (calculaPuntuacionMaquina(
                                    cambioImagenJ1,
                                    cambioImagenMaquina
                                ) > calculaPuntuacionJ1(cambioImagenJ1, cambioImagenMaquina)
                            ) {
                                val toast = Toast
                                    .makeText(context, "¡Ganador Máquina!", Toast.LENGTH_SHORT)
                                    .show()
                            } else {
                                val toast = Toast
                                    .makeText(context, "¡EMPATE!", Toast.LENGTH_SHORT)
                                    .show()
                            }

                            partidasJugadas += 1
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
                            puntuacionMaquina += calculaPuntuacionMaquina(
                                cambioImagenJ1,
                                cambioImagenMaquina
                            )

                            if (calculaPuntuacionJ1(
                                    cambioImagenJ1,
                                    cambioImagenMaquina
                                ) > calculaPuntuacionMaquina(cambioImagenJ1, cambioImagenMaquina)
                            ) {
                                val toast = Toast
                                    .makeText(context, "¡Ganador J1!", Toast.LENGTH_SHORT)
                                    .show()
                            } else if (calculaPuntuacionMaquina(
                                    cambioImagenJ1,
                                    cambioImagenMaquina
                                ) > calculaPuntuacionJ1(cambioImagenJ1, cambioImagenMaquina)
                            ) {
                                val toast = Toast
                                    .makeText(context, "¡Ganador Máquina!", Toast.LENGTH_SHORT)
                                    .show()
                            } else {
                                val toast = Toast
                                    .makeText(context, "¡EMPATE!", Toast.LENGTH_SHORT)
                                    .show()
                            }

                            partidasJugadas += 1
                        }
                )
                Text(
                    text = "Tijeras",
                    modifier = modifier.padding(5.dp)
                )
            }
        }
    }

    if (partidasJugadas == 5){
        if (puntuacionJ1 > puntuacionMaquina){
            val toast = Toast.makeText(context, "¡J1 ha ganado la partida!", Toast.LENGTH_SHORT).show()
        } else if (puntuacionMaquina > puntuacionJ1){
            val toast = Toast.makeText(context, "¡Máquina ha ganado la partida!", Toast.LENGTH_SHORT).show()
        } else {
            val toast = Toast.makeText(context, "¡Ha habido EMPATE!", Toast.LENGTH_SHORT).show()
        }

        puntuacionJ1 = 0
        puntuacionMaquina = 0
        partidasJugadas = 0
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun login (modifier: Modifier = Modifier){
    var nombre: String = ""

    Column (horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize()){
        Row (){
            Image(painter = painterResource(id = R.drawable.ppt),
                contentDescription = "logoLogin")
        }

        Spacer(modifier = modifier.size(15.dp))

        Row {
            OutlinedTextField(
                value = nombre,
                onValueChange = {nombre = it},
                label = { Text("Nombre Jugador")})
        }

        Spacer(modifier = modifier.size(20.dp))

        Row {
            Button(onClick = {  }){
                Text(text = "Jugar")
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

fun ganador (puntJ1: Int, puntMaquina: Int): Int{
    if (puntJ1>puntMaquina){
        return 1
    } else if (puntMaquina>puntJ1){
        return 2
    } else {
        return 0
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PiedraPapelTijerasTheme {
        login()
    }
}