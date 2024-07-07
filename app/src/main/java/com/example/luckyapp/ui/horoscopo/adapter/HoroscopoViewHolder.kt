package com.example.luckyapp.ui.horoscopo.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.luckyapp.databinding.ItemHoroscopoBinding
import com.example.luckyapp.domain.model.HoroscopoInfo

class HoroscopoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopoBinding.bind(view)

    fun render(horoscopo: HoroscopoInfo, onHoroscopoSelected: (HoroscopoInfo) -> Unit) {
        binding.ivHoroscopo.setImageResource(horoscopo.img)
        //obtengo el string de el archivo strings en res.values con getString ya que en
        //la sealed class de HoroscopoInfo hay una referencia al string que va
        //y no el string en sí
        binding.tvHoroscopo.text = binding.tvHoroscopo.context.getString(horoscopo.name)

        //cuando hago click en el item entero, porque es binding.root q se refiere a la vista completa del item
        binding.root.setOnClickListener {
            animation(binding.ivHoroscopo, {
                onHoroscopoSelected(horoscopo)
            })
        }

    }

    private fun animation(view: View, lambda: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationYBy(360f)
            rotationXBy(360f)
            //acá dice qué ejecuta cuando la animación termina
            withEndAction(lambda)
            start()
        }
    }
}