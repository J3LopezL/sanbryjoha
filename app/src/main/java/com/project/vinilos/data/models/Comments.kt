package com.project.vinilos.data.models

import java.io.Serializable

data class Comments (
    val id : Int,
    val description : String,
    val rating : Int
) : Serializable