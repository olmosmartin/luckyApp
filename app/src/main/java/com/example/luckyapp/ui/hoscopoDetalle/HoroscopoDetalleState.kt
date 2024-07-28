package com.example.luckyapp.ui.hoscopoDetalle

import com.example.luckyapp.domain.model.HoroscopoEnum

sealed class HoroscopoDetalleState {
    object Loading : HoroscopoDetalleState()
    data class Success(val data: String, val horoscopoEnum: HoroscopoEnum) : HoroscopoDetalleState()
    data class Error(val error: String) : HoroscopoDetalleState()
}