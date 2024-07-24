package com.example.luckyapp.ui.hoscopoDetalle

sealed class HoroscopoDetalleState {
    object Loading : HoroscopoDetalleState()
    data class Success(val data: String) : HoroscopoDetalleState()
    data class Error(val error: String) : HoroscopoDetalleState()
}