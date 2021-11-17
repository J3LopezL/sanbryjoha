package com.project.vinilos.model.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

// metodo de configuracion de retrofit para hacer la peticion y convertir Json en Obj Dataclass
object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://vinyl-miso.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}