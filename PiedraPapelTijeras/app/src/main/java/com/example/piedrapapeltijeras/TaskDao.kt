package com.example.piedrapapeltijeras

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.piedrapapeltijeras.entidades.TaskEntity

@Dao
interface TaskDao {
    @Query("SELECT * FROM Puntuacion")
    suspend fun getAllTasks(): MutableList<TaskEntity>  // Función que devuelve todas las tareas de la base de datos en una lista Mutable.

    @Insert
    suspend fun addTask(taskEntity : TaskEntity):Long    // Función que añade una tarea, la que se pasa por parámetro, y devuelve el id insertado.                                                          // Devuelve Long porque la cantidad de datos guardada puede ser muy alto.

    @Query("SELECT * FROM Puntuacion where nickUsuario like :id")
    suspend fun getTaskById(id: Long): TaskEntity        // Función que busca tareas por id (debe ser Long, no Int)

    @Update
    suspend fun updateTask(task: TaskEntity):Int         // Función que actualiza una tarea y devuelve

    @Delete
    suspend fun deleteTask(task: TaskEntity):Int         // Función que borra una tarea y devuelve
}