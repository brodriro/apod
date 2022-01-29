package com.brodriro.apod.presentation.apods.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.brodriro.apod.databinding.ItemPostBinding
import com.brodriro.apod.domain.entities.PostEntity
import com.squareup.picasso.Picasso

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(post: PostEntity, listener: PostAdapter.AdapterListener) {
        val bind = ItemPostBinding.bind(itemView)
        bind.tvCopyright.text = post.copyright

        if (post.url.isNotEmpty()) {
            Picasso.get()
                .load(post.url)
                .into(bind.ivPicture);
        }

        bind.view.setOnClickListener {
            listener.onItemClickListener(post, bind.ivPicture)
        }
    }
}