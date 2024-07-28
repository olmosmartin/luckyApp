package com.example.luckyapp.ui.hoscopoDetalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.luckyapp.domain.model.HoroscopoEnum
import com.example.luckyapp.domain.model.HoroscopoModel
import com.example.luckyapp.domain.usecase.GetDetalleSigno
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//inyecto getDetalleSigno de la clase GetDetalleSigno y como es la única del tipo GetDetalleSigno sabe cual buscar
//puesto q fue inyectada cuando se puso @Inject en GetDetalleSigno y entro en el grafo de dependencias de Hilt
@HiltViewModel
class HoroscopoDetalleViewModel @Inject constructor(private val getDetalleSigno: GetDetalleSigno) :
    ViewModel() {
    //cuando creo el mutable state flow le paso un estado por defecto q es HoroscopoDetalleState.Loading
    private var _state = MutableStateFlow<HoroscopoDetalleState>(HoroscopoDetalleState.Loading)
    val state: StateFlow<HoroscopoDetalleState> = _state

    lateinit var horoscopo: HoroscopoEnum

    //este metodo se llama cuando se crea el viewmodel, es como un oncreate
//    init {
//    }

    fun getDetalle(sign: HoroscopoEnum) {
        horoscopo = sign
        viewModelScope.launch {
            _state.value = HoroscopoDetalleState.Loading
            //uso el hilo secundario para los llamando de retrofit para no tildar el hilo principal que se usa para la ui
            // porque por defecto viewModelScope.launch usa el hilo principal
            val result  = withContext(Dispatchers.IO){
                getDetalleSigno(sign.name)
            }
            if (result!=null){
                _state.value = HoroscopoDetalleState.Success(result.horoscope, horoscopo)
            } else {
                _state.value = HoroscopoDetalleState.Error("Ocurrió un error")
            }
        }
    }
}