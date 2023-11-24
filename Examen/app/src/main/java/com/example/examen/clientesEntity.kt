package com.example.examen

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clientesTable")
data class clientesEntity  (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val SalaElegida: Int = 0,
    val palomitas: Int
)


