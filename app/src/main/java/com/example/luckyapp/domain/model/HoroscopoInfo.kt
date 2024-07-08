package com.example.luckyapp.domain.model

import com.example.luckyapp.R

sealed class HoroscopoInfo(val img: Int, val name: Int, val tipo: HoroscopoEnum) {
    data object Aries : HoroscopoInfo(R.drawable.aries, R.string.aries, HoroscopoEnum.Aries)
    data object Tauro : HoroscopoInfo(R.drawable.tauro, R.string.taurus, HoroscopoEnum.Tauro)
    data object Geminis : HoroscopoInfo(R.drawable.geminis, R.string.gemini, HoroscopoEnum.Geminis)
    data object Cancer : HoroscopoInfo(R.drawable.cancer, R.string.cancer, HoroscopoEnum.Cancer)
    data object Leo : HoroscopoInfo(R.drawable.leo, R.string.leo, HoroscopoEnum.Leo)
    data object Virgo : HoroscopoInfo(R.drawable.virgo, R.string.virgo, HoroscopoEnum.Virgo)
    data object Libra : HoroscopoInfo(R.drawable.libra, R.string.libra, HoroscopoEnum.Libra)
    data object Scorpio : HoroscopoInfo(R.drawable.escorpio, R.string.scorpio, HoroscopoEnum.Escorpio)
    data object Sagitario : HoroscopoInfo(R.drawable.sagitario, R.string.sagittarius, HoroscopoEnum.Sagitario)
    data object Capricornio : HoroscopoInfo(R.drawable.capricornio, R.string.capricorn, HoroscopoEnum.Capricornio)
    data object Aquario : HoroscopoInfo(R.drawable.aquario, R.string.aquarius, HoroscopoEnum.Acuario)
    data object Piscis : HoroscopoInfo(R.drawable.piscis, R.string.piscis, HoroscopoEnum.Piscis)
}