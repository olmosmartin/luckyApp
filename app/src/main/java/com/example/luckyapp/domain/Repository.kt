package com.example.luckyapp.domain

import com.example.luckyapp.domain.model.HoroscopoModel

//creo una interface para pedir lo q necesito a la capa de data
// pero la implementaicon va a estar en data

interface Repository {
    suspend fun getDetailByname(sign: String): HoroscopoModel?
}