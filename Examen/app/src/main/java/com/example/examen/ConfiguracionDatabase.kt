package com.example.examen

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [configuracionEntity::class], version = 1)
abstract class ConfiguracionDatabase: RoomDatabase() {
    abstract fun configuracionDao(): ConfiguracionDao
}