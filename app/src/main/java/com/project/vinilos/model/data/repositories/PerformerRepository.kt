package com.project.vinilos.model.data.repositories

import com.project.vinilos.model.data.models.dataClass.Performer
import com.project.vinilos.model.data.models.providers.PerformerProvider
import com.project.vinilos.model.data.network.PerformerService

class PerformerRepository {

    private val api = PerformerService()

    suspend fun getAllPerformers():List<Performer>{
        val response = api.getPerformers()
        PerformerProvider.performers = response
        return response
    }
}