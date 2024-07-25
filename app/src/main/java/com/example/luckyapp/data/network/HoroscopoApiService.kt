package com.example.luckyapp.data.network

import com.example.luckyapp.data.network.responseModel.HoroscopoRespuesta
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopoApiService {

    @GET("{sign}")
    suspend fun getDetailByname(@Path("sign") sign: String): HoroscopoRespuesta

}