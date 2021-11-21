package com.project.vinilos.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.vinilos.R


import com.project.vinilos.model.data.models.dataClass.Performer
import com.project.vinilos.model.data.models.dataClass.Tracks


import kotlinx.android.synthetic.main.item_track.view.*

class TracksAdapter(private var tracks:List<Tracks>, var performers:List<Performer>):RecyclerView.Adapter<TracksAdapter.TrackHolder>(){
    inner class TrackHolder(val view:View):RecyclerView.ViewHolder(view){
        fun render(track:Tracks){
            view.tvTrackTitle.text = track.name
            view.tvTrackDuration.text = track.duration

            var performer = "Desconocido"
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