package com.project.vinilos.model.data.network

import com.project.vinilos.model.core.RetrofitHelper
import com.project.vinilos.model.data.models.dataClass.Album
import com.project.vinilos.model.data.models.dataClass.Tracks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class TrackService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun createTrack(track : HashMap<String,String>, albumId : Int): Response<Tracks> {
        return retrofit.create(TrackApiClient::class.java).createTrack(albumId, track)
    }
}