package com.project.vinilos.model.data

import com.project.vinilos.model.data.models.Performer
import com.project.vinilos.model.data.models.PerformerProvider
import com.project.vinilos.model.data.network.PerformerService

class PerformerRepository {

    private val api = PerformerService()

    suspend fun getAllPerformers():List<Performer>{
        val response = api.getPerformers()
        PerformerProvider.performers = response
        return response
    }
}