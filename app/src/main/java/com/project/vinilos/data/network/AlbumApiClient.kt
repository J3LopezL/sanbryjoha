package com.project.vinilos.data.network

import com.project.vinilos.data.models.Album
import retrofit2.Response
import retrofit2.http.GET

interface AlbumApiClient {
    @GET("albums")
    suspend fun getAllAlbums():Response<List<Album>>
}