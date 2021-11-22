package com.project.vinilos.model.data.network

import com.project.vinilos.model.core.RetrofitHelper
import com.project.vinilos.model.data.models.dataClass.Collector
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CollectorService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getCollectors():List<Collector> {
        return   withContext(Dispatchers.IO) {
            val response = retrofit.create(CollectorApiClient::class.java).getAllCollectors()
            response.body() ?: emptyList()
        }
    }


}