package com.project.vinilos.model.data.models.dataClass

import java.io.Serializable

data class Performer (
    val id : Int,
    val name : String,
    val image : String,
    val description : String,
    val birthDate : String,
    val albums : List<Album>
) : Serializable