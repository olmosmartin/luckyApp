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
        initUI()
    }

    private fun initUI() {
        //creo una corrutina lifecycleScope que sirve en los fragments y activity para lanzar corrutinas
        //que se ejecuten en el ciclo de vida del fragment, muriendo cuando muera el fragment
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoDetalleViewModel.state.collect { horoscopoDetalleState ->
                    Log.i("horoscopo detyalle activity statevm", "initui: "+horoscopoDetalleState)
                    when(horoscopoDetalleState) {
                        is HoroscopoDetalleState.Error -> errorState()
                        HoroscopoDetalleState.Loading -> loadingState()
                        is HoroscopoDetalleState.Success -> successState()
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.pbLoading.visibility = View.VISIBLE
    }
    private fun errorState() {
        TODO("Not yet implemented")
    }
    private fun successState() {
        TODO("Not yet implemented")
    }

}