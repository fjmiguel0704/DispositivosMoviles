package com.example.agendacompose

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactos")
data class ContactoEntity (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0, // Id de la tarea
    var name:String = "", // Nombre de la tarea
    var tlfno:Int = 0, // Booleano que indica si la tarea está hecha o no
    var genero: String = ""
){

}