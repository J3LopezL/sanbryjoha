package com.project.vinilos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.vinilos.model.data.models.dataClass.Collector
import com.project.vinilos.model.domain.GetCollectorUseCase
import kotlinx.coroutines.launch

class CollectorViewModel: ViewModel() {

    // encapsula el model que tenemos en un LiveData
    // se mete en un mutable por que el valor va a cambiar
    val collectorModelLiveData = MutableLiveData<List<Collector>>()
    val getCollectorUseCase = GetCollectorUseCase()

    fun  onCreate() {
        println("****************************************")
        println("CollectorViewModel")
        // corrutina - Se ejecuta en otro hilo para no bloquear el principal
        // scope es donde se va a ejecutar la corrutuina
        viewModelScope.launch {
            getCollectorUseCase.metodo()
            val result = getCollectorUseCase()
            // verifica si la respuesta de la api no es null o empty y la ponemos en el liveData para uso en la activity
            if (!result.isNullOrEmpty()){
                // Se notifica de los cambio que se presentan en el MutableLiveData en este caso en el DataClass Collector
                collectorModelLiveData.value = result
            }
        }
    }



}