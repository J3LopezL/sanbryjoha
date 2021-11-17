package com.project.vinilos.model.data.models.dataClass

import java.io.Serializable

data class Collector(
    val id:Int,
    var name:String,
    val telephone:String,
    val email: String,
    val comments: List<Comments>,
    val favoritePerformers: List<Performer>,
    val collectorAlbums: List<CollectorAlbums>,
    ) : Serializable