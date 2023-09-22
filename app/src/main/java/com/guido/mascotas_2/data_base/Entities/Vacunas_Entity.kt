package com.guido.mascotas_2.data_base.Entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vacunas")
data class Vacunas_Entity(
    @PrimaryKey(autoGenerate = true) var id:Int,
    @ColumnInfo(name = "vacuna") var vacuna:String,
    @ColumnInfo(name = "descripcion") var descripcion:String
) {
    override fun toString(): String {
        return vacuna
    }


}
