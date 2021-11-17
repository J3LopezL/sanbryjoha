package com.project.vinilos.view
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.vinilos.R
import com.project.vinilos.model.data.models.dataClass.Performer
import com.squareup.picasso.Picasso
import com.squareup.picasso.MemoryPolicy
import kotlinx.android.synthetic.main.item_performer.view.*

class PerformersAdapter(
    var performers:List<Performer>,
    private val listener:OnItemClickListener
    ):RecyclerView.Adapter<PerformersAdapter.PerformerHolder>(){

    inner class PerformerHolder(val view:View):RecyclerView.ViewHolder(view), View.OnClickListener{
        fun render(performer:Performer){
            view.tvPerformerName.text = performer.name
            view.tvPerformerBirthDate.text = performer.birthDate.substring(0,10)
            Picasso.get().load(performer.image)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(view.ivPerformerImage)
            Picasso.get().load(performer.image)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(view.ivPerformerAvatar)
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val performer = performers[adapterPosition]
            listener.onItemClick(performer)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerformerHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PerformerHolder(layoutInflater.inflate(R.layout.item_performer, parent, false))
    }

    override fun onBindViewHolder(holder: PerformerHolder, position: Int) {
        holder.render(performers[position])
    }

    override fun getItemCount(): Int = performers.size

    interface OnItemClickListener{
        fun onItemClick(performer:Performer)
    }
}