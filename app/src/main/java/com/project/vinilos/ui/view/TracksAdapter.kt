package com.project.vinilos.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.vinilos.R
import com.project.vinilos.data.models.Album
import com.project.vinilos.data.models.Performers
import com.project.vinilos.data.models.Tracks
import com.squareup.picasso.Picasso
import com.squareup.picasso.MemoryPolicy
import kotlinx.android.synthetic.main.album_scrolling_content.view.*
import kotlinx.android.synthetic.main.item_album.view.*
import kotlinx.android.synthetic.main.item_track.view.*
import java.text.SimpleDateFormat

class TracksAdapter(var tracks:List<Tracks>, var performers:List<Performers>):RecyclerView.Adapter<TracksAdapter.TrackHolder>(){
    inner class TrackHolder(val view:View):RecyclerView.ViewHolder(view){
        fun render(track:Tracks){
            view.tvTrackTitle.text = track.name
            view.tvTrackDuration.text = track.duration

            var performer:String = "Desconocido"
            if (performers.isNotEmpty()){
                performer = performers[0].name
            }

            view.tvTrackArtist.text = performer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TrackHolder(layoutInflater.inflate(R.layout.item_track, parent, false))
    }

    override fun onBindViewHolder(holder: TrackHolder, position: Int) {
        holder.render(tracks[position])
    }

    override fun getItemCount(): Int = tracks.size
}