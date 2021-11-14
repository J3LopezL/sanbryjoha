package com.project.vinilos.model.data.models

import java.io.Serializable
import java.sql.Timestamp

data class Album (
    val id:Int,
    val name:String,
    val cover:String,
    val releaseDate:Timestamp,
    val description:String,
    val genre:String,
    val recordLabel:String,
    val tracks : List<Tracks>,
    val performers : List<Performer>,
    val comments : List<Comments>
) : Serializable