package com.guido.mascotas_2.data_base.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "razas",
    foreignKeys = [ForeignKey(
        entity = Tipos_MascotasEntity::class,
        parentColumns = ["id"],
        childColumns = ["id_tipo"])
    ])
 data class RazasEntity(
        @PrimaryKey(autoGenerate = true) var id: Int,
        @ColumnInfo(name = "raza") var raza:String,
        @ColumnInfo(name = "id_tipo") var id_tipo: Int
    ) {
    override fun toString(): String {
        return raza
    }
}
