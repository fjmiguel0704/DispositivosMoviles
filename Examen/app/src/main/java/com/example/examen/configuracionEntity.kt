package com.example.examen

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "configuracionTable")
data class configuracionEntity (
    @PrimaryKey(autoGenerate = false)
    val numSalas: Int,
    val numAsientos: Int,
    val nombre: String,
    val precioPalomitas: Float
)