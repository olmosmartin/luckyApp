package com.example.luckyapp.ui.hoscopoDetalle

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopoDetalleViewModel @Inject constructor(): ViewModel() {
    //cuando creo el mutable state flow le paso un estado por defecto q es HoroscopoDetalleState.Loading
    private var _state = MutableStateFlow<HoroscopoDetalleState>(HoroscopoDetalleState.Loading)
    val state: StateFlow<HoroscopoDetalleState> = _state

    //este metodo se llama cuando se crea el viewmodel, es como un oncreate
//    init {
//    }
}