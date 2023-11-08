package com.example.piedrapapeltijeras

import android.app.Application
import androidx.room.Room

class MisNotasApp: Application() {
    companion object{
        lateinit var  database: PuntuacionDatabase
    }

    override fun onCreate() {
        super.onCreate()
        MisNotasApp.database = Room.databaseBuilder(this, PuntuacionDatabase::class.java, "PuntuacionJugadores").build()
    }
}