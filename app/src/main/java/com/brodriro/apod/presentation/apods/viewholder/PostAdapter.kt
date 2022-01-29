package com.brodriro.apod.presentation.apods.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brodriro.apod.R
import com.brodriro.apod.domain.entities.PostEntity

class PostAdapter(val list: List<PostEntity>, val listener: AdapterListener) : RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = list[position]
        holder.bind(post, listener)
    }

    override fun getItemCount(): Int = list.size

    interface AdapterListener {
        fun onItemClickListener(postEntity: PostEntity, ivPicture: View)
    }
}