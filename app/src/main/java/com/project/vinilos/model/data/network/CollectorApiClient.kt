package com.project.vinilos.model.data.network

import com.project.vinilos.model.data.models.dataClass.Collector
import retrofit2.Response
import retrofit2.http.GET

interface CollectorApiClient {
    @GET("collectors")
    suspend fun getAllCollectors(): Response<List<Collector>>
}