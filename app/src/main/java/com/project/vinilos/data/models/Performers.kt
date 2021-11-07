package com.project.vinilos.data.models

import java.io.Serializable

data class Performers (
    val id : Int,
    val name : String,
    val image : String,
    val description : String,
    val birthDate : String
) : Serializable