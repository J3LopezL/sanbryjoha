package com.project.vinilos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.vinilos.model.data.models.dataClass.Collector
import com.project.vinilos.model.domain.GetCollectorUseCase
import kotlinx.coroutines.launch

class CollectorViewModel: ViewModel() {

    val collectorModelLiveData = MutableLiveData<List<Collector>>()
    val getCollectorUseCase = GetCollectorUseCase()

    fun  onCreate() {
        viewModelScope.launch {
            val result = getCollectorUseCase()
            if (!result.isNullOrEmpty()){
                collectorModelLiveData.value = result
            }
        }
    }



}