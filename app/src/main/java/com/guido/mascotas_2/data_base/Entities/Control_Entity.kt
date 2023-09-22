package com.guido.mascotas_2.data_base.Entities


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "control_vacuna",
    foreignKeys = [
        ForeignKey(
            entity = Mascotas_Entity::class,
            parentColumns = ["id"],
            childColumns = ["id_mascotas"]
        ),
        ForeignKey(
            entity = Vacunas_Entity::class,
            parentColumns = ["id"],
            childColumns = ["id_vacunas"]
        )
    ]
)
data class Control_Entity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "id_mascotas") var id_mascotas: Int,
    @ColumnInfo(name = "id_vacunas") var id_vacunas: Int,
    @ColumnInfo(name = "fecha_vacuna") var fecha:String
){

}
