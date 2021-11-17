package com.project.vinilos.model.domain

import com.project.vinilos.model.data.PerformerRepository
import com.project.vinilos.model.data.models.Performer

class GetPerformersUseCase {
    private val repository = PerformerRepository()

    suspend operator fun invoke(): List<Performer> = repository.getAllPerformers()
}