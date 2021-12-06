package com.project.vinilos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.vinilos.model.data.models.dataClass.Tracks
import com.project.vinilos.model.data.repositories.TrackRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class TrackViewModel : ViewModel() {
    val trackResponse = MutableLiveData<Response<Tracks>>()

    fun onCreate() {
    }

    fun createTrack(track : HashMap<String,String>, albumId : Int) {
        viewModelScope.launch {
            val response = TrackRepository().createTrack(track, albumId)
            trackResponse.value = response
        }
    }
}