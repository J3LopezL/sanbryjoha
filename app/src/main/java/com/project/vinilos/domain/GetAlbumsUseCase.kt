package com.project.vinilos.domain

import com.project.vinilos.data.AlbumRepository
import com.project.vinilos.data.models.Album

class GetAlbumsUseCase {
    private val repository = AlbumRepository()

    suspend operator fun invoke():List<Album> = repository.getAllAlbums()
}