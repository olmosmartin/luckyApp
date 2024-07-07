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
        /*
        * la parte de cancelar la animacion y de reestablecer la vista a su estado inicial es necesaria
        * porque si no se hace la imagen se rompe con un press antes de que termine la animacion ya que
        * la animacion se inicia sin antes terminar y el estado final queda
        * con 360 grados de vuelta pero desde una cantidad de grados ya aplicada sobre el view
        */

        // Cancelar la animación anterior si está en curso
        view.animate().cancel()

        // Restablecer la vista a su estado inicial
        view.rotationY = 0f
        view.rotationX = 0f

        // Iniciar la nueva animación
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationYBy(360f)
            rotationXBy(360f)
            // Acá dice qué ejecuta cuando la animación termina
            withEndAction(lambda)
            start()
        }
    }
}