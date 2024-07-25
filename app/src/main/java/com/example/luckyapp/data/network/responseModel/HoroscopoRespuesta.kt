package com.example.luckyapp.data.network.responseModel

import com.example.luckyapp.domain.model.HoroscopoModel
import com.google.gson.annotations.SerializedName

data class HoroscopoRespuesta (
    @SerializedName("date") val dia: String,
    @SerializedName("horoscope") val horoscope: String,
//    @SerializedName("icon") val icon: String,
//    @SerializedName("id") val id: Int,
    @SerializedName("sign") val sign: String
) {
    //funcion para mapear los datos de HoroscopoRespuesta en HoroscopoModel
    fun toDomain():HoroscopoModel{
        return HoroscopoModel(
            dia = this.dia,
            horoscope = this.horoscope,
            sign = this.sign
        )
    }
}