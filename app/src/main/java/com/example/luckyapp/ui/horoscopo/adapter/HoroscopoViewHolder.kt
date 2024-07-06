package com.example.luckyapp.ui.horoscopo.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.luckyapp.databinding.ItemHoroscopoBinding
import com.example.luckyapp.domain.model.HoroscopoInfo

class HoroscopoViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopoBinding.bind(view)

    fun render(horoscopo: HoroscopoInfo) {
        binding.ivHoroscopo.setImageResource(horoscopo.img)
        //obtengo el string de el archivo strings en res.values con getString ya que en
        //la sealed class de HoroscopoInfo hay una referencia al string que va
        //y no el string en sí
        binding.tvHoroscopo.text = binding.tvHoroscopo.context.getString(horoscopo.name)
    }
}