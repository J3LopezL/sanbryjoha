package com.project.vinilos.model.domain

import com.project.vinilos.model.data.AlbumRepository
import com.project.vinilos.model.data.models.Album

class GetAlbumsUseCase {
    private val repository = AlbumRepository()

    suspend operator fun invoke():List<Album> = repository.getAllAlbums()
}