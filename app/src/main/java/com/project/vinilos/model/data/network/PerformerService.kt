package com.project.vinilos.model.data.network

import com.project.vinilos.model.core.RetrofitHelper
import com.project.vinilos.model.data.models.dataClass.Performer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PerformerService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPerformers():List<Performer> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(PerformerApiClient::class.java).getAllPerformers()
            response.body() ?: emptyList()
        }
    }
}