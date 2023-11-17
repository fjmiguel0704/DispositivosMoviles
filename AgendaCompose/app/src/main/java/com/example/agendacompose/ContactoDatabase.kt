package com.example.agendacompose

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ContactoDatabase::class), version = 1)
abstract class ContactoDatabase: RoomDatabase() {
    abstract fun ContactosDao(): ContactoDao
}