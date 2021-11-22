package com.project.vinilos.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.vinilos.R
import com.project.vinilos.model.data.models.dataClass.Collector
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_collector.view.*

class CollectorAdapter (var collector:List<Collector>, private val listener:OnItemClickListener)
    :RecyclerView.Adapter<CollectorAdapter.CollectorHolder>(){


        inner class CollectorHolder(val view: View): RecyclerView.ViewHolder(view), View.OnClickListener{
            fun render(collector: Collector){
                view.tvCollectorName.text = collector.name
                view.tvCollectorPhone.text = collector.telephone
                view.tvCollectorEmail.text = collector.email

                Picasso.get().load(collector.favoritePerformers[0].image)
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .into(view.ivCollectorCover)
            }

            init {
                itemView.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                val collector = collector[adapterPosition]
                listener.onItemClick(collector)
            }
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectorHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return CollectorHolder(layoutInflater.inflate(R.layout.item_collector, parent, false))
        }
        override fun onBindViewHolder(holder: CollectorHolder, position: Int) {
            holder.render(collector[position])
        }

        override fun getItemCount(): Int = collector.size

        interface OnItemClickListener{
            fun onItemClick(collector: Collector)
        }
}