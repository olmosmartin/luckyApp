package com.example.luckyapp.data.network

import com.example.luckyapp.BuildConfig.BASE_URL
import com.example.luckyapp.data.RepositoryImp
import com.example.luckyapp.data.core.interceptor.AuthInterceptor
import com.example.luckyapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //proveo un Retrofit
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor):OkHttpClient{
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(interceptor)
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