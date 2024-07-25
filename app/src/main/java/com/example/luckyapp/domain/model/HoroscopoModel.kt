package com.example.luckyapp.domain.model

//es el mismo que horoscopo respuesta de la capa de data pero sin la libreria de @SerializedName
//que pertene a logica de android y no deberia usarse en esta capa
data class HoroscopoModel (
    val dia: String,
    val horoscope: String,
    val sign: String
)