package com.project.vinilos.model.domain

import com.project.vinilos.model.data.models.dataClass.Collector
import com.project.vinilos.model.data.network.CollectorService
import com.project.vinilos.model.data.repositories.CollectorRepository

class GetCollectorUseCase {


    private val repository = CollectorRepository()
    suspend operator fun invoke():List<Collector> = repository.getAllCollectors()

    suspend fun invoke_log(): Unit = metodo()

    suspend fun metodo(){
        println("****************************************")
        println("GetCollectorUseCase")
        CollectorService().getCollectors()
    }
}