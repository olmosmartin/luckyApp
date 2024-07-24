package com.example.luckyapp.data.network.responseModel

import com.google.gson.annotations.SerializedName

data class HoroscopoRespuesta (
    @SerializedName("date") val dia: String,
    @SerializedName("horoscope") val horoscope: String,
//    @SerializedName("icon") val icon: String,
//    @SerializedName("id") val id: Int,
    @SerializedName("sign") val sign: String
)