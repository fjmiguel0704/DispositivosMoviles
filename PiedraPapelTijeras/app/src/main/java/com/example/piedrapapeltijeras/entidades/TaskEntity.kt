package com.example.piedrapapeltijeras.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Puntuacion")
data class TaskEntity (
    @PrimaryKey(autoGenerate = true)
    var nickUsuario: Int = 0,
    var numPartidas: Int = 0,
    var maxPuntuacion: Int = 0
) {
}