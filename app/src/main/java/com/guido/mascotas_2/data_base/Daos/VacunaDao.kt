package com.guido.mascotas_2.data_base.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.guido.mascotas_2.data_base.Entities.Vacunas_Entity

@Dao
interface VacunaDao {
    @Query("SELECT * FROM vacunas ORDER BY id ASC")
    fun getAll():List<Vacunas_Entity>


    @Update
    fun update(tipo:Vacunas_Entity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tipo: Vacunas_Entity)

    @Delete
    fun delete(tipo: Vacunas_Entity)
}