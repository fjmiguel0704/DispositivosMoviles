package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "PantallaInicio"
                ) {
                    composable(route = "PantallaInicio"){ PantallaInicio(navController) }
                    composable(route = "ConfiguracionBasica"){ConfiguracionBasica(navController)}
                    composable(route = "ListaNumerada"){ListaNumerada(navController)}
                    composable(route = "ResumenAsistencia"){ResumenAsistencia(navController) }
                    composable(route = "DetallesSala"){ DetallesSala(navController) }
                }

            }
        }
    }
}