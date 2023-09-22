package com.guido.mascotas_2.data_base.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.guido.mascotas_2.data_base.Entities.Mascotas_Entity

@Dao
interface MascotasDao {
    @Query("select * from mascotas order by id asc")
    fun getAll():List<Mascotas_Entity>

    @Update()
    fun update(tipo:Mascotas_Entity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(tipo: Mascotas_Entity)

    @Delete()
    fun delete(tipo: Mascotas_Entity)

}