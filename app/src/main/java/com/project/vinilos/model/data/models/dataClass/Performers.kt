package com.project.vinilos.model.data.models.dataClass

import java.io.Serializable

data class Performers (
    val id : Int,
    val name : String,
    val image : String,
    val description : String,
    val birthDate : String
) : Serializable