package com.guido.mascotas_2.data_base

import android.content.ContentValues
import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.OnConflictStrategy
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.guido.mascotas_2.data_base.Daos.ControlDao
import com.guido.mascotas_2.data_base.Daos.MascotasDao
import com.guido.mascotas_2.data_base.Daos.RazasDao
import com.guido.mascotas_2.data_base.Daos.TiposDao
import com.guido.mascotas_2.data_base.Daos.VacunaDao
import com.guido.mascotas_2.data_base.Entities.Control_Entity
import com.guido.mascotas_2.data_base.Entities.Mascotas_Entity
import com.guido.mascotas_2.data_base.Entities.RazasEntity
import com.guido.mascotas_2.data_base.Entities.Tipos_MascotasEntity
import com.guido.mascotas_2.data_base.Entities.Vacunas_Entity

@Database(
    entities = [
        Vacunas_Entity::class,
        Tipos_MascotasEntity::class,
        RazasEntity::class,
        Mascotas_Entity::class,
        Control_Entity::class
    ], version = 1
)


abstract class db_mascotas : RoomDatabase() {
    abstract fun mascotas_Dao(): MascotasDao

    abstract fun control_Dao(): ControlDao

    abstract fun vacunas_Dao(): VacunaDao

    abstract fun tipos_Dao(): TiposDao

    abstract fun razas_Dao():RazasDao

    companion object {
        @Volatile
        private var INSTANCE: db_mascotas? = null
        fun getDatabase(context: Context): db_mascotas {
            if (INSTANCE != null) {
                return INSTANCE!!
            }

            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                db_mascotas::class.java,
                "mascotas"
            ).addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    var list = listOf(
                        Tipos_MascotasEntity(0, "Perro"),
                        Tipos_MascotasEntity(0, "gato"),
                        Tipos_MascotasEntity(0, "conejo"),
                        Tipos_MascotasEntity(0, "hamster"),
                    )

                    list.forEach {
                        db.insert("tipos_de_mascotas", 0, ContentValues().apply {
                            put("tipo", it.tipo)
                        })
                    }

                    var list_Raza = listOf(
                        RazasEntity(0,"pitbull",1),
                        RazasEntity(0,"labrador",1),
                        RazasEntity(0,"dalmata",1),
                        RazasEntity(0,"pastor aleman",1),
                        RazasEntity(0,"comun",1),
                        RazasEntity(0,"Asiático",2),
                        RazasEntity(0,"Siberiano",2),
                        RazasEntity(0,"Bengalí",2),
                        RazasEntity(0,"Persa",2),
                        RazasEntity(0,"comun",2),
                        RazasEntity(0,"Conejo de Angora",3),
                        RazasEntity(0,"Belier",3),
                        RazasEntity(0,"Mini Lop",3),
                        RazasEntity(0,"Jersey Wooly",3),
                        RazasEntity(0,"comun",3),
                        RazasEntity(0,"ruso",4),
                        RazasEntity(0,"sirio o dorado",4),
                        RazasEntity(0,"chino",4),
                        RazasEntity(0,"enano de Campbell",4),
                        RazasEntity(0,"comun",4)
                    )

                    list_Raza.forEach {
                        Log.e("Data", "onCreate: $it")
                        db.insert("razas", 0, ContentValues().apply {
                            put("raza", it.raza)
                            put("id_tipo", it.id_tipo)
                        })
                    }

                    var list_vacunas = listOf(
                        Vacunas_Entity(0,"Leptospirosis","Para los que hacen mucha vida exterior"),
                        Vacunas_Entity(0,"Traqueítis infecciosa","Para los que van a residencias o casas de acogida"),
                        Vacunas_Entity(0,"Leishmania","para los que viven en zonas donde el mosquito que la transmite es muy común"),
                        Vacunas_Entity(0,"Rabia","Esta es la única vacuna obligatoria"),
                        Vacunas_Entity(0,"Parvovirus","Para todos las mascotas"),
                        Vacunas_Entity(0,"moquillo","Para todos las mascotas"),
                        Vacunas_Entity(0,"adenovirus","Para todos las mascotas"),
                        Vacunas_Entity(0,"hepatitis","Para todos las mascotas")
                        )
                    list_vacunas.forEach {
                        Log.e("Data", "onCreate: $it")
                        db.insert("vacunas", 0, ContentValues().apply {
                            put("vacuna", it.vacuna)
                            put("descripcion", it.descripcion)
                        })
                    }
                }
            }).build()
            return INSTANCE!!
        }


    }


}
