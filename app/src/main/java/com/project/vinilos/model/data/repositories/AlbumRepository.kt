package com.project.vinilos.model.data.repositories

import com.project.vinilos.model.data.models.dataClass.Album
import com.project.vinilos.model.data.models.providers.AlbumProvider
import com.project.vinilos.model.data.network.AlbumService
import retrofit2.Response

class AlbumRepository {

    private val api = AlbumService()

    suspend fun getAllAlbums():List<Album>{
        val response = api.getAlbums()
        response.also { it.also { AlbumProvider.albums } }
        return response
    }

    suspend fun createAlbum(album : HashMap<String,String>):Response<Album>{
        val response = api.createAlbum(album)
        response.also { it.also { AlbumProvider.album } }
        return response
    }
}