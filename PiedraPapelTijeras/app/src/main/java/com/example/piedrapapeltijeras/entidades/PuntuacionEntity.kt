package com.example.piedrapapeltijeras.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PuntuacionJugadores")
data class PuntuacionEntity (
    @PrimaryKey(autoGenerate = true)
    var nickUsuario: Int = 0,
    var numPartidas: Int = 0,
    var maxPuntuacion: Int = 0
) {
}