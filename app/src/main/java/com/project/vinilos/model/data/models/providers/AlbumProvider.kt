package com.project.vinilos.model.data.models.providers

import com.project.vinilos.model.data.models.dataClass.Album

class AlbumProvider {
    // como clase statica all acces it
    companion object {
       var albums:List<Album> = emptyList()
    }
}