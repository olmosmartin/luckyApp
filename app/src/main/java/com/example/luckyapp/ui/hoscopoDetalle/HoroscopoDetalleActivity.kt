package com.example.luckyapp.ui.hoscopoDetalle

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import com.example.luckyapp.databinding.ActivityHoroscopoDetalleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoroscopoDetalleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopoDetalleBinding
    private val horoscopoDetalleViewModel by viewModels<HoroscopoDetalleViewModel>()

    private val args: HoroscopoDetalleActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopoDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("HoroscopoDetalleActivity", "onCreate: ${args.HoroscopoTipo}")
    }
}