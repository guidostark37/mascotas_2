package com.guido.mascotas_2.data_base.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.guido.mascotas_2.data_base.Entities.Control_Entity

@Dao
interface ControlDao {
    @Query("select * from control_vacuna order by id asc")
    fun getAll():List<Control_Entity>


    @Update()
    fun update(tipo:Control_Entity)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(tipo: Control_Entity)

    @Delete()
    fun delete(tipo: Control_Entity)

}