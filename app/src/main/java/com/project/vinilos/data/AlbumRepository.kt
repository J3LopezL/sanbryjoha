package com.project.vinilos.data

import com.project.vinilos.data.models.Album
import com.project.vinilos.data.models.AlbumProvider
import com.project.vinilos.data.network.AlbumService

class AlbumRepository {

    private val api = AlbumService()

    suspend fun getAllAlbums():List<Album>{
        val response = api.getAlbums()
        AlbumProvider.albums = response
        return response
    }
}