package com.example.piedrapapeltijeras

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.piedrapapeltijeras.entidades.PuntuacionEntity

@Database(entities = arrayOf(PuntuacionEntity::class), version = 1)
abstract class PuntuacionDatabase: RoomDatabase() {
    abstract fun taskDao():PuntuacionDao
}