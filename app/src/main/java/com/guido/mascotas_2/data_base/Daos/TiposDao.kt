package com.guido.mascotas_2.data_base.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.guido.mascotas_2.data_base.Entities.Tipos_MascotasEntity

@Dao
interface TiposDao {
    @Query("select * from tipos_de_mascotas order by id asc")
    fun getAll():List<Tipos_MascotasEntity>

    @Update()
    fun update(tipo: Tipos_MascotasEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(tipo: Tipos_MascotasEntity)

    @Delete()
    fun delete(tipo: Tipos_MascotasEntity)
}