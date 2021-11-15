package com.project.vinilos.model.domain

import com.project.vinilos.model.data.repositories.AlbumRepository
import com.project.vinilos.model.data.models.dataClass.Album

class GetAlbumsUseCase {
    private val repository = AlbumRepository()
    suspend operator fun invoke():List<Album> = repository.getAllAlbums()
}