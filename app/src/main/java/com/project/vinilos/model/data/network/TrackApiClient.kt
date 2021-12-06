package com.project.vinilos.model.data.network

import com.project.vinilos.model.data.models.dataClass.Tracks
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface TrackApiClient {
    @POST("albums/{album_id}/tracks")
    suspend fun createTrack(
        @Path("album_id") albumId: Int,
        @Body track : HashMap<String, String>
    ): Response<Tracks>
}