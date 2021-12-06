package com.project.vinilos.model.data.models.dataClass

import java.io.Serializable

data class Tracks (
    val id : Int,
    val name : String,
    val duration : String
) : Serializable {
    constructor() : this(0, "", "")
}