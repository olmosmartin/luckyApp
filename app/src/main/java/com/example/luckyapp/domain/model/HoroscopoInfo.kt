package com.example.luckyapp.domain.model

import com.example.luckyapp.R

sealed class HoroscopoInfo (val img: Int, val name: Int) {
    data object Aries:HoroscopoInfo(R.drawable.aries, R.string.aries)
    data object Tauro: HoroscopoInfo(R.drawable.tauro, R.string.taurus)
    data object Geminis: HoroscopoInfo(R.drawable.geminis, R.string.gemini)
    data object Cancer: HoroscopoInfo(R.drawable.cancer, R.string.cancer)
    data object Leo: HoroscopoInfo(R.drawable.leo, R.string.leo)
    data object Virgo: HoroscopoInfo(R.drawable.virgo, R.string.virgo)
    data object Libra: HoroscopoInfo(R.drawable.libra, R.string.libra)
    data object Scorpio: HoroscopoInfo(R.drawable.escorpio, R.string.scorpio)
    data object Sagitario: HoroscopoInfo(R.drawable.sagitario, R.string.sagittarius)
    data object Capricornio: HoroscopoInfo(R.drawable.capricornio, R.string.capricorn)
    data object Aquario: HoroscopoInfo(R.drawable.aquario, R.string.aquarius)
    data object Piscis: HoroscopoInfo(R.drawable.piscis, R.string.piscis)
}