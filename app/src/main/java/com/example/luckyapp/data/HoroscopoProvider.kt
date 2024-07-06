package com.example.luckyapp.data

import com.example.luckyapp.domain.model.HoroscopoInfo
import javax.inject.Inject

class HoroscopoProvider @Inject constructor() {

    public fun getHoroscopo(): List<HoroscopoInfo> {

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