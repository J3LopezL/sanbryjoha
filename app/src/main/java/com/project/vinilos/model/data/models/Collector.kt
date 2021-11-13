package com.project.vinilos.model.data.models

import java.io.Serializable
import java.sql.Timestamp

data class Collector (
    val id:Int,
    val name:String,
    val telephone:String,
    val email: Timestamp,
    val comments : List<Comments>,
    val favoritePerformers : List<Performers>,
    val collectorAlbums : List<CollectorAlbums>,
    ) : Serializable