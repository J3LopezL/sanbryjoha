package com.project.vinilos.model.data.network

import com.project.vinilos.model.data.models.dataClass.Album
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AlbumApiClient {
    @GET("albums")
    suspend fun getAllAlbums():Response<List<Album>>

    @POST("albums")
     suspend fun createAlbum(
        @Body album : HashMap<String,String>
    ):Response<Album>
}