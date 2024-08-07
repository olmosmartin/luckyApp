package com.example.luckyapp.data.providers

import com.example.luckyapp.domain.model.HoroscopoInfo
import javax.inject.Inject

class HoroscopoProvider @Inject constructor() {

    fun getHoroscopo(): List<HoroscopoInfo> {

        return listOf(
            HoroscopoInfo.Aries,
            HoroscopoInfo.Tauro,
            HoroscopoInfo.Geminis,
            HoroscopoInfo.Cancer,
            HoroscopoInfo.Leo,
            HoroscopoInfo.Virgo,
            HoroscopoInfo.Libra,
            HoroscopoInfo.Scorpio,
            HoroscopoInfo.Sagitario,
            HoroscopoInfo.Capricornio,
            HoroscopoInfo.Aquario,
            HoroscopoInfo.Piscis
        )

    }
}