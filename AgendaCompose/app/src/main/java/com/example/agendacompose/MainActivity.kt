package com.example.agendacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItemList(
                itemContacto = listOf(
                    Contacto("Juan Miguel Gomez", "665452423", "Hombre"),
                    Contacto("Fernando Jimenez Romero", "665452423", "Hombre"),
                    Contacto("Maria Auxiliadora", "665452423", "Mujer"),
                    Contacto("Alicia Amante Vega", "665452423", "Mujer"),
                    Contacto("Lucia Miguel Gomez", "665452423", "Mujer"),
                    Contacto("Manuel Trujano", "665452423", "Hombre"),
                    Contacto("Yeray Moreno", "665452423", "Hombre"),
                    Contacto("Antonio Jimnez Negrete", "665452423", "Hombre"),
                    Contacto("Lucas Monte", "665452423", "Hombre"),
                    Contacto("Alejandro Reinoso", "665452423", "Hombre"),
                    Contacto("Pablo Guerrero", "665452423", "Hombre"),
                    Contacto("Nerea Guttierrez", "665452423", "Mujer"),
                    Contacto("Isabel Bejarano", "665452423", "Mujer"),
                    Contacto("Carmen Lorence", "665452423", "Mujer"),
                    Contacto("Teresa Campos", "665452423", "Mujer"),
                    Contacto("Pedro Gallardo", "665452423", "Hombre")
                )
            )
        }
    }
    @Composable
    fun ItemList(itemContacto: List<Contacto>){
        LazyColumn{
            items(itemContacto){
                itemContacto -> ContactoView(contacto = itemContacto)
            }
        }
    }

    @Composable
    fun ContactoView (contacto: Contacto){
        Card (Modifier.fillMaxWidth()){
            Row {
                Column {
                    Image(
                       painter = painterResource(id = R.drawable.iconperson),
                        contentDescription = "Foto contacto",
                        Modifier.height(100.dp)
                    )
                }

                Column {
                    Text(
                        text = contacto.nombre,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )

                    Text(
                        text = contacto.tfno,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}