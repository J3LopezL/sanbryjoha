package com.project.vinilos.model.data.models.dataClass

import java.io.Serializable

data class Comments (
    val id : Int,
    val description : String,
    val rating : Int
) : Serializable