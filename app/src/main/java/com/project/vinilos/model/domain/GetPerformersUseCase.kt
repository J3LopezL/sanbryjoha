package com.project.vinilos.model.domain

import com.project.vinilos.model.data.repositories.PerformerRepository
import com.project.vinilos.model.data.models.dataClass.Performer

class GetPerformersUseCase {
    private val repository = PerformerRepository()

    suspend operator fun invoke(): List<Performer> = repository.getAllPerformers()
}