package com.example.examen

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [clientesEntity::class], version = 1)
abstract class ClientesDatabase: RoomDatabase() {
    abstract fun clientesDao(): ClientesDao
}