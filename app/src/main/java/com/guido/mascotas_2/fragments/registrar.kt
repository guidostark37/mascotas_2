package com.guido.mascotas_2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.guido.mascotas_2.data_base.Entities.Tipos_MascotasEntity
import com.guido.mascotas_2.data_base.db_mascotas
import com.guido.mascotas_2.databinding.FragmentRegistrarBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.SQLClientInfoException

private var binding1: FragmentRegistrarBinding? = null
private val binding get() = binding1!!

class registrar : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    fun queryDatabase(second: () -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            second.invoke()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding1 = FragmentRegistrarBinding.inflate(inflater, container, false)
        binding.spinnerTipos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                Toast.makeText(this@registrar.requireActivity(), "${p3}", Toast.LENGTH_SHORT).show()
                queryDatabase {
                    val dbMascotas = db_mascotas.getDatabase(this@registrar.requireContext())
                    val lista =
                        dbMascotas.razas_Dao().getAll().filter { x -> x.id_tipo.toLong() == p3 }
                    requireActivity().runOnUiThread {
                        val adapter = ArrayAdapter(
                            this@registrar.requireActivity(),
                            android.R.layout.simple_spinner_dropdown_item,
                            lista
                        )
                        binding.spinnerRazas.adapter = adapter
                    }

                }

                //val lista = dbMascotas.razas_Dao().getAll().filter { x-> x.id_tipo == id }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


        CoroutineScope(Dispatchers.IO).launch {
            val dbMascotas = db_mascotas.getDatabase(this@registrar.requireContext())


            try {
                val list = dbMascotas.tipos_Dao().getAll()

                requireActivity().runOnUiThread {
                    val adapter = object : ArrayAdapter<Tipos_MascotasEntity>(
                        this@registrar.requireActivity(),
                        android.R.layout.simple_spinner_dropdown_item,
                        list
                    ) {
                        override fun getItemId(position: Int): Long {
                            return getItem(position)?.id!!.toLong()
                        }
                    }

                    binding.spinnerTipos.adapter = adapter

                }
            } catch (e: SQLClientInfoException) {
                Log.e("este es tu error", e.message.toString())
            } catch (e: Exception) {
                Log.e("kgao", e.message.toString())
            }

        }

        return binding.root
    }


}