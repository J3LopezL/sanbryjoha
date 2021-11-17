package com.project.vinilos.model.data.models.providers

import com.project.vinilos.model.data.models.dataClass.Collector
import com.project.vinilos.model.data.models.dataClass.CollectorAlbums
import com.project.vinilos.model.data.models.dataClass.Comments
import com.project.vinilos.model.data.models.dataClass.Performer

class CollectorProvider {
    companion object {
    var collector:List<Collector> = emptyList()
    }

//    // test de vista con data mock
//    companion object {
//
//        fun getCollectors(): Collector {
//            var position: Int = (0..1).random();
//            return collectorsList[position];
//        }
//
//        val comments = Comments(
//            100,
//            "The most relevant album of Ruben Blades",
//            5
//        )
//        val performer = Performers(
//            100,
//            "Rubén Blades Bellido de Luna",
//            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Ruben_Blades_by_Gage_Skidmore.jpg/800px-Ruben_Blades_by_Gage_Skidmore.jpg",
//            "Es un cantante, compositor, músico, actor, abogado, político y activista panameño. Ha desarrollado gran parte de su carrera artística en la ciudad de Nueva York.",
//            "1948-07-16T00:00:00.000Z"
//        )
//
//        val collectorAlbums = CollectorAlbums(
//            100,
//            35,
//            "Active"
//        )
//
//        val collectorAlbumsList = listOf<CollectorAlbums>(
//            collectorAlbums
//        )
//        val performerList = listOf<Performers>(
//            performer,
//            performer,
//            performer
//        )
//        var collectorsList = listOf<Collector>(
//            Collector(
//                100,
//                "Manolo Bellon",
//                "3502457896",
//                "manollo@caracol.com.co",
//                comments,
//                performerList,
//                collectorAlbumsList
//            ),
//            Collector(
//                200,
//                "Manolo Bellon",
//                "3502457896",
//                "manollo@caracol.com.co",
//                comments,
//                performerList,
//                collectorAlbumsList
//            )
//        )
//    }
}