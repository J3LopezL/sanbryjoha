package com.project.vinilos.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://vinyl-miso.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}