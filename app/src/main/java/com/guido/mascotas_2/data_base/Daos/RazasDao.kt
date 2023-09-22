package com.guido.mascotas_2.data_base.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.guido.mascotas_2.data_base.Entities.RazasEntity


@Dao
interface RazasDao {

    @Query("select * from razas order by id asc")
    fun getAll():List<RazasEntity>


    @Update()
    fun update(tipo: RazasEntity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(tipo: RazasEntity)

    @Delete()
    fun delete(tipo:RazasEntity)

}