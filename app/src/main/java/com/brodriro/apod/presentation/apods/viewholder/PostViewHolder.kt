package com.brodriro.apod.presentation.apods.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.brodriro.apod.databinding.ItemPostBinding
import com.brodriro.apod.domain.entities.PostEntity

class PostViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(post: PostEntity) {
        val bind = ItemPostBinding.bind(itemView)
        bind.tvCopyright.text = post.copyright
    }
}