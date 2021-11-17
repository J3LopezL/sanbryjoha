package com.project.vinilos.model.data.repositories

import com.project.vinilos.model.data.models.dataClass.Collector
import com.project.vinilos.model.data.models.providers.CollectorProvider
import com.project.vinilos.model.data.network.CollectorService

class CollectorRepository {

    private val api = CollectorService()

    suspend fun getAllCollectors():List<Collector>{
        println("****************************************")
        println("CollectorRepository")
        val response = api.getCollectors()
        CollectorProvider.collector = response
        return response
    }
}