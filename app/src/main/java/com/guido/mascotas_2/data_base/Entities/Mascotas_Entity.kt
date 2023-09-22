package com.guido.mascotas_2.data_base.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "mascotas",
    foreignKeys = [ ForeignKey(
        entity = Tipos_MascotasEntity::class,
        parentColumns = ["id"],
        childColumns = ["id_tipo"]
    )]
)
data class Mascotas_Entity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "nombre") var nombre: String,
    @ColumnInfo(name = "edad") var edad: Int,
    @ColumnInfo(name = "id_tipo") var id_tipo: Int

)
