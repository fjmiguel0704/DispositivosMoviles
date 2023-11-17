package com.example.agendacompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


    @Composable
    fun listarContactos(navController: NavController) {

         var contacto = Contacto("","","")
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .padding(10.dp)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.iconperson),
                            contentDescription = "Foto contacto",
                            Modifier.size(60.dp)
                        )
                    }

                    Column {
                        Text(
                            text = contacto.nombre,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(8.dp)
                        )

                        Text(
                            text = contacto.tfno,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.anadir),
                        contentDescription = "Add",
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment.BottomEnd)
                            .clip(CircleShape)
                            .background(color = Color.LightGray)
                            .clickable {
                                navController.navigate("modificarContacto/${5}")
                            }
                    )
                }

            }
        }

    }


    @Composable
    fun ItemList(itemContacto: List<Contacto>) {
        LazyColumn {
            items(itemContacto) { itemContacto ->
                ContactoView(contacto = itemContacto)
            }
        }
    }

    @Composable
    fun ContactoView(contacto: Contacto) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .padding(10.dp)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.iconperson),
                            contentDescription = "Foto contacto",
                            Modifier.size(60.dp)
                        )
                    }

                    Column {
                        Text(
                            text = contacto.nombre,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(8.dp)
                        )

                        Text(
                            text = contacto.tfno,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.anadir),
                        contentDescription = "Add",
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment.BottomEnd)
                            .clip(CircleShape)
                            .background(color = Color.LightGray)
                            .clickable {

                            }
                    )
                }

            }
        }
    }

    @Composable
    fun botonFlotante() {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.anadir),
                contentDescription = "Add",
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.BottomEnd)
                    .clip(CircleShape)
                    .background(color = Color.LightGray)
                    .clickable {

                    }
            )
        }
    }
