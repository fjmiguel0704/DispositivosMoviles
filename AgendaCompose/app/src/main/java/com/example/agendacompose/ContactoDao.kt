package com.example.agendacompose

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactoDao {
    @Query("SELECT * FROM contactos")
    suspend fun getAllContactos(): MutableList<ContactoEntity>  // Función que devuelve todas las tareas de la base de datos en una lista Mutable.

    @Insert
    suspend fun addContactos(contactosEntity : ContactoEntity):Long    // Función que añade una tarea, la que se pasa por parámetro, y devuelve el id insertado.                                                          // Devuelve Long porque la cantidad de datos guardada puede ser muy alto.

    @Query("SELECT * FROM contactos where id like :id")
    suspend fun getContactosById(id: Long): ContactoEntity        // Función que busca tareas por id (debe ser Long, no Int)

    @Update
    suspend fun updateContactos(contac: ContactoEntity):Int         // Función que actualiza una tarea y devuelve

    @Delete
    suspend fun deleteContactos(contac: ContactoEntity):Int         // Función que borra una tarea y devuelve
}
