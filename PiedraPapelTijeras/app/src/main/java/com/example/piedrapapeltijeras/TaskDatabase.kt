package com.example.piedrapapeltijeras

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.piedrapapeltijeras.entidades.TaskEntity

@Database(entities = arrayOf(TaskEntity::class), version = 1)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun taskDao():TaskDao
}