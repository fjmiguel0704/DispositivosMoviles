package com.example.examen

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ConfiguracionDao {
    @Query("SELECT * FROM configuracionTable")
    suspend fun getAllContactos(): MutableList<configuracionEntity>

    //@Query("SELECT numSalas FROM configuracionTable")
    //suspend fun getNumSalas(): configuracionEntity

    //@Query("SELECT numAsientos FROM configuracionTable")
    //suspend fun getNumAsientos(): configuracionEntity

    @Update
    suspend fun updateContacto(idCliente: configuracionEntity)
}