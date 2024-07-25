package com.example.luckyapp.data

import android.util.Log
import com.example.luckyapp.data.network.HoroscopoApiService
import com.example.luckyapp.domain.Repository
import com.example.luckyapp.domain.model.HoroscopoModel
import javax.inject.Inject


//dagerhilt va a buscar el constructor q le devuelva un HoroscopoApiService,
//al no encontrarlo va a buscar en los modulos que tienen la anotacion @Module
//y va a encontrar en NetworkModule el metodo llamado provideHoroscopoApiService y va a darme ese singleton
class RepositoryImp @Inject constructor(private val horoscopoApiService: HoroscopoApiService) :
    Repository {

    override suspend fun getDetailByname(sign: String): HoroscopoModel? {
        kotlin.runCatching { horoscopoApiService.getDetailByname(sign) }
            .onSuccess {
                Log.i("error ", "correcto")
                return it.toDomain()
            }
            .onFailure {
                Log.i("error: ", "${it.message}")
            }
        return null
    }

}