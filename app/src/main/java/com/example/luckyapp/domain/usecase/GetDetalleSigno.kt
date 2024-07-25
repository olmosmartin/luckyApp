package com.example.luckyapp.domain.usecase

import com.example.luckyapp.domain.Repository
import com.example.luckyapp.domain.model.HoroscopoModel
import javax.inject.Inject

//ya se está proveyendo un repositoty en NetworkModule con dagerhilt asi que va a tomar ese
class GetDetalleSigno @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(sign: String): HoroscopoModel? {
        return repository.getDetailByname(sign)
    }
}