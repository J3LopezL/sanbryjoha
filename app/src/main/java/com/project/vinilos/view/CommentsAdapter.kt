package com.project.vinilos.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.vinilos.R
import com.project.vinilos.model.data.models.dataClass.Comments
import com.project.vinilos.model.data.models.dataClass.Performer
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_comments_collector.view.*
import kotlinx.android.synthetic.main.item_performer.view.*

class CommentsAdapter (
    var comments:List<Comments>,
): RecyclerView.Adapter<CommentsAdapter.CollectorHolder>(){

    // paint values of views
    inner class CollectorHolder(val view: View):RecyclerView.ViewHolder(view), View.OnClickListener {

        fun render(comment: Comments){
            view.descriptionComments.text = comment.description
            view.personComments.text = comment.id.toString()
            view.rating.setRating(comment.rating.toFloat())
        }

        override fun onClick(v: View?) {
            println("Onclick Adapter view")
        }

    }

    // create the view holder with layout of item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectorHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CollectorHolder(layoutInflater.inflate(R.layout.item_comments_collector, parent, false))
    }

    // render views item into recycler view
    override fun onBindViewHolder(holder: CollectorHolder, position: Int) {
        holder.render(comments[position])
    }
    // say Recycler view how many items it list have
    // if we put return 2 it only show 2 items
    override fun getItemCount():  Int = comments.size

}