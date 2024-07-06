package com.example.luckyapp.ui.horoscopo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.luckyapp.R
import com.example.luckyapp.domain.model.HoroscopoInfo

class HoroscopoAdaptervar(var horoscopoList: List<HoroscopoInfo> = emptyList()) :
    RecyclerView.Adapter<HoroscopoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscopo, parent, false)
        return HoroscopoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return horoscopoList.size
    }

    override fun onBindViewHolder(holder: HoroscopoViewHolder, position: Int) {
        holder.render(horoscopoList[position])
    }

    fun updateList(horoscopoList: List<HoroscopoInfo>) {
        this.horoscopoList = horoscopoList
        //voy a cambiar el listado de una sola completo vez asi que notifyDataSetChanged no es ineficiente
        notifyDataSetChanged()
    }

}