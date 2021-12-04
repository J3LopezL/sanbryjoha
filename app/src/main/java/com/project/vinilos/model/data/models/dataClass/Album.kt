package com.project.vinilos.model.data.models.dataClass

import java.io.Serializable
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalTime.now

data class Album (
    val id:Int,
    val name:String,
    val cover:String,
    val releaseDate:Timestamp,
    val description:String,
    val genre:String,
    val recordLabel:String,
    var tracks : List<Tracks>,
    val performers : List<Performer>,
    val comments : List<Comments>
) : Serializable {
    constructor() : this(0, "",
        "", Timestamp(System.currentTimeMillis()),
        "", "",
        "", emptyList(),
        emptyList(), emptyList())
}