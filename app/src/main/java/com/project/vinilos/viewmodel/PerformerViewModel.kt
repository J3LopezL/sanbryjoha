package com.project.vinilos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.vinilos.model.data.models.dataClass.Performer
import com.project.vinilos.model.domain.GetPerformersUseCase
import kotlinx.coroutines.launch

class PerformerViewModel : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()

    val performer = MutableLiveData<List<Performer>>()

    val getPerformersUseCase = GetPerformersUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPerformersUseCase()

            if (!result.isNullOrEmpty()){
                performer.value = result
                isLoading.postValue(false)
            }
        }
    }
}