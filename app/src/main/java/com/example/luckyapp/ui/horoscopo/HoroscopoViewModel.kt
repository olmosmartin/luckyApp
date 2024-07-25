package com.example.luckyapp.ui.horoscopo

import androidx.lifecycle.ViewModel
import com.example.luckyapp.data.providers.HoroscopoProvider
import com.example.luckyapp.domain.model.HoroscopoInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopoViewModel @Inject constructor(private val horoscopoProvider: HoroscopoProvider) :
    ViewModel() {
    private var _horoscopo = MutableStateFlow<List<HoroscopoInfo>>(emptyList())
    val horoscopo: StateFlow<List<HoroscopoInfo>> = _horoscopo

    //este metodo se llama cuando se crea el viewmodel, es como un oncreate
    init {
        _horoscopo.value = horoscopoProvider.getHoroscopo()
    }
}