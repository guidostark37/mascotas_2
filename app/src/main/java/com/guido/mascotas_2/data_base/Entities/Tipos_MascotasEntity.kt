package com.guido.mascotas_2.data_base.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tipos_de_mascotas")
data class Tipos_MascotasEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "tipo") var tipo: String
){
    override fun toString(): String {
        return id.toString() + " " + tipo
    }
}
