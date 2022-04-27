package com.example.myapplicationwebservice.webservice

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "http://192.168.1.108/webservice/webservice.php/"
object RetrofitInstance {
    private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

    }
    val instance: DaoArticle by lazy {
        retrofit.create(DaoArticle::class.java)
    }
}