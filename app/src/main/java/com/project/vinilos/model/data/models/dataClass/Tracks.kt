package com.project.vinilos.model.data.models.dataClass

import java.io.Serializable
import java.sql.Timestamp

data class Tracks (
    val id : Int,
    val name : String,
    val duration : String
) : Serializable {
    constructor() : this(0, "", "")
}