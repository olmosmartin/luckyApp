package com.example.luckyapp.data.network

import com.example.luckyapp.data.RepositoryImp
import com.example.luckyapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //proveo un Retrofit
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://newastro.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //proveo un HoroscopoApiService
    //este provide va a usar el provideRetrofit creado acá mismo cuando le pase el retrofit
    //por parametro (retrofit: Retrofit) porque provideRetrofit devuelve un tipo de dato Retrofit
    @Provides
    fun provideHoroscopoApiService(retrofit: Retrofit): HoroscopoApiService {
        return retrofit.create(HoroscopoApiService::class.java)
    }

    //proveo un Repository
    //si hubiese q poner varias anotaciones q hagan privide de lo mismo se puede poner una anotacion name
    //puedo pasarle un HoroscopoApiService porque provideHoroscopoApiService ya lo provee entonces
    //dagerhilt automaticamente se lo pasa al provide nuevo
    @Provides
    fun provideHoroscopoRepository(apiService: HoroscopoApiService): Repository {
        return RepositoryImp(apiService)
    }
}