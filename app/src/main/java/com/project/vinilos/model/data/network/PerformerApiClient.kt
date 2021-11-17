package com.project.vinilos.model.data.network


import com.project.vinilos.model.data.models.dataClass.Performer
import retrofit2.Response
import retrofit2.http.GET

interface PerformerApiClient {
    @GET("musicians")
    suspend fun getAllPerformers():Response<List<Performer>>
}