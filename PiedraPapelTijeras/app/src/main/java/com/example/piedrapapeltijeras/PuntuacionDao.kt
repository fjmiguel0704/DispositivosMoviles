package com.example.piedrapapeltijeras

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.piedrapapeltijeras.entidades.PuntuacionEntity

@Dao
interface PuntuacionDao {
    @Query("SELECT * FROM PuntuacionJugadores")
    suspend fun getAllTasks(): MutableList<PuntuacionEntity>  // Función que devuelve todas las tareas de la base de datos en una lista Mutable.

    @Insert
    suspend fun addTask(taskEntity : PuntuacionEntity):Long    // Función que añade una tarea, la que se pasa por parámetro, y devuelve el id insertado.                                                          // Devuelve Long porque la cantidad de datos guardada puede ser muy alto.

    @Query("SELECT * FROM PuntuacionJugadores where nickUsuario like :id")
    suspend fun getTaskById(id: Long): PuntuacionEntity        // Función que busca tareas por id (debe ser Long, no Int)

    @Update
    suspend fun updateTask(task: PuntuacionEntity):Int         // Función que actualiza una tarea y devuelve

    @Delete
    suspend fun deleteTask(task: PuntuacionEntity):Int         // Función que borra una tarea y devuelve
}