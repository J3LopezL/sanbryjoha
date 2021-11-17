package com.project.vinilos.model.data.network

import com.project.vinilos.model.data.models.dataClass.Album
import retrofit2.Response
import retrofit2.http.GET

interface AlbumApiClient {
    @GET("albums")
    suspend fun getAllAlbums():Response<List<Album>>
}