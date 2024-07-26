package com.example.luckyapp.ui.hoscopoDetalle

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.luckyapp.databinding.ActivityHoroscopoDetalleBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoDetalleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopoDetalleBinding
    private val horoscopoDetalleViewModel by viewModels<HoroscopoDetalleViewModel>()

    private val args: HoroscopoDetalleActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopoDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        horoscopoDetalleViewModel.getDetalle(args.HoroscopoTipo.name)
        initUI()
    }

    private fun initUI() {
        //inicio los listeners:
        binding.btnBabackButton.setOnClickListener {
            //pongo para volver a la pantalla anterior:
            onBackPressed()
        }

        //creo una corrutina lifecycleScope que sirve en los fragments y activity para lanzar corrutinas
        //que se ejecuten en el ciclo de vida del fragment, muriendo cuando muera el fragment
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoDetalleViewModel.state.collect { horoscopoDetalleState ->
                    Log.i("horoscopo detyalle activity statevm", "initui: " + horoscopoDetalleState)
                    when (horoscopoDetalleState) {
                        is HoroscopoDetalleState.Error -> errorState()
                        HoroscopoDetalleState.Loading -> loadingState()
                        is HoroscopoDetalleState.Success -> successState(horoscopoDetalleState)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.pbLoading.visibility = View.VISIBLE
    }

    private fun errorState() {
        binding.pbLoading.visibility = View.GONE
    }

    private fun successState(horoscopoDetalleState: HoroscopoDetalleState.Success) {
        binding.pbLoading.visibility = View.GONE
        binding.tvContent.text = horoscopoDetalleState.data
        binding.tvHoroscopoDetalle.text = args.HoroscopoTipo.name
        Log.i("horoscopo statevm", "successState: " + horoscopoDetalleState.data)
    }

}