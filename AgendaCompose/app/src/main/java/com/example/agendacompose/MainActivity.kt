package com.example.agendacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room

class MainActivity : ComponentActivity() {
    companion object{
        lateinit var database: ContactoDatabase
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(this, ContactoDatabase::class.java, "contactos").build()
        setContent {
            val navController = rememberNavController()
            Column {
                NavHost(
                    navController = navController,
                    startDestination = "listarContactos"
                ){
                    composable(route = "listarContactos") {listarContactos(navController)}
                    composable(route = "AñadirContato") {añadirContato(navController)}
                    composable(route = "ModificarContacto/{id}", arguments = listOf(navArgument("id") {
                        type = NavType.LongType})){
                        modificarContacto(navController, it.arguments?.getLong("id")?:1)
                    }
                }
            }
        }
    }
}