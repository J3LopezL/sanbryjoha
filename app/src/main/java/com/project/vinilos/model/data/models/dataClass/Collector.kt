package com.project.vinilos.model.data.models.dataClass

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Collector(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    var name:String,
    val telephone:String,
    val email: String,
    val comments: List<Comments>,
    val favoritePerformers: List<Performer>,
    val collectorAlbums: List<CollectorAlbums>,
    ) : Serializable