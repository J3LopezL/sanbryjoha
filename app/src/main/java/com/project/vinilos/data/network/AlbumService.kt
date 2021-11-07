package com.project.vinilos.data.network

import com.project.vinilos.core.RetrofitHelper
import com.project.vinilos.data.models.Album
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AlbumService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAlbums():List<Album> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(AlbumApiClient::class.java).getAllAlbums()
            response.body() ?: emptyList()
        }
    }
}