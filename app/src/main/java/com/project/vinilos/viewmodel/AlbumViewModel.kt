package com.project.vinilos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.vinilos.model.data.models.dataClass.Album
import com.project.vinilos.model.domain.GetAlbumsUseCase
import kotlinx.coroutines.launch

class AlbumViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val album = MutableLiveData<List<Album>>()

    val getAlbumsUseCase = GetAlbumsUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAlbumsUseCase()

            if (!result.isNullOrEmpty()){
                album.value = result
                isLoading.postValue(false)
            }
        }
    }
}