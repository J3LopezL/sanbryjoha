package com.project.vinilos.model.data.network

import com.project.vinilos.model.core.RetrofitHelper
import com.project.vinilos.model.data.models.dataClass.Album
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class AlbumService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAlbums():List<Album> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(AlbumApiClient::class.java).getAllAlbums()
            response.body() ?: emptyList()
        }
    }

    suspend fun createAlbum(album : HashMap<String,String>): Response<Album> {
        return retrofit.create(AlbumApiClient::class.java).createAlbum(album)
    }
}