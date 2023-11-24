package com.example.examen

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ClientesDao {
    @Query("SELECT * FROM clientesTable")
    suspend fun getAllContactos(): MutableList<clientesEntity>

    @Query("SELECT * FROM clientesTable WHERE id = :id")
    suspend fun getContacto(id: Int): clientesEntity

    @Insert
    suspend fun insertContacto(contacto: clientesEntity)

    @Update
    suspend fun updateContacto(contacto: clientesEntity)

    @Delete
    suspend fun deleteContacto(contacto: clientesEntity)
}