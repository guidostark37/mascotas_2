package com.guido.mascotas_2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guido.mascotas_2.R
import com.guido.mascotas_2.data_base.Entities.Vacunas_Entity
import com.guido.mascotas_2.databinding.ItemVacunasBinding

class adapter_vacunas(var list:List<Vacunas_Entity>):RecyclerView.Adapter<adapter_vacunas.vacunaHolder>() {

    inner class vacunaHolder(var binding:ItemVacunasBinding):RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vacunaHolder {
        return vacunaHolder(
            ItemVacunasBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_vacunas,parent,false)
            )
        )
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: vacunaHolder, position: Int) {

    }
}