package com.project.vinilos.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.vinilos.R
import com.project.vinilos.model.data.models.dataClass.Performer
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_performers_collector.view.*

class PerformerAdapter (
    var favoritePerformers:List<Performer>
    ): RecyclerView.Adapter<PerformerAdapter.PerformerHolder>(){

    // paint values of views
    inner class PerformerHolder(val view: View):RecyclerView.ViewHolder(view), View.OnClickListener {

        fun render(performer: Performer){

            view.tvPerformerName.text = performer.name
            view.tvDescriptionPerformer.text = performer.description
            Picasso.get().load(performer.image)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(view.ivPerformerAvatar)
        }

        override fun onClick(v: View?) {
            println("Onclick Adapter view")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerformerHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return PerformerHolder(layoutInflater.inflate(R.layout.item_performers_collector, parent, false))
    }

    override fun onBindViewHolder(holder: PerformerAdapter.PerformerHolder, position: Int) {
        holder.render(favoritePerformers[position])
    }

    override fun getItemCount(): Int = favoritePerformers.size

}