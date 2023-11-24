package com.example.examen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.nio.file.WatchEvent

@Composable
fun PantallaInicio(navController: NavController){
    Column (Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row  {
            Button(onClick = { navController.navigate("ConfiguracionBasica")},
                Modifier.width(130.dp)) {
                Text(text = "Configuración Básica")
            }
            Button(onClick = { navController.navigate("ListaNumerada") },
                Modifier.width(130.dp)) {
                Text(text = "Lista Numerada")
            }
        }

        Row {
            Button(onClick = { navController.navigate("ResumenAsistencia") },
                Modifier.width(130.dp)) {
                Text(text = "Resumen de asistencia")
            }
            Button(onClick = { navController.navigate("DetallesSala") },
                Modifier.width(130.dp)) {
                Text(text = "Detalles sala")
            }
        }
    }
}

@Composable
fun ConfiguracionBasica(navController: NavController){
    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Configuración Básica", fontSize = 50.sp, fontWeight = FontWeight.Bold)
    }
}


@Composable
fun ListaNumerada(navController: NavController){
    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Lista numerada", fontSize = 50.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ResumenAsistencia(navController: NavController){
    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Resumen de asistencia", fontSize = 50.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun DetallesSala(navController: NavController){
    Column (Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Detalles de la sala", fontSize = 50.sp, fontWeight = FontWeight.Bold)
    }
}


