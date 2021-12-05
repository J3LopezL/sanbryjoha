package com.project.vinilos.model.data.repositories

import com.project.vinilos.model.data.models.dataClass.Album
import com.project.vinilos.model.data.models.dataClass.Tracks
import com.project.vinilos.model.data.models.providers.AlbumProvider
import com.project.vinilos.model.data.models.providers.TrackProvider
import com.project.vinilos.model.data.network.AlbumService
import com.project.vinilos.model.data.network.TrackService
import retrofit2.Response

class TrackRepository {
    private val api = TrackService()

    suspend fun createTrack(track : HashMap<String,String>, albumId : Int): Response<Tracks> {
        val response = api.createTrack(track, albumId)
        response.also { it.also { TrackProvider.track } }
        return response
    }
}