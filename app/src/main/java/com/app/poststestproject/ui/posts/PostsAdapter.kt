package com.app.poststestproject.ui.posts

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.poststestproject.R
import com.app.poststestproject.data.model.Post

class PostsAdapter(private val posts: ArrayList<Post>) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postTitleTxt.text = posts[position].title
        holder.postShortDescTxt.text = posts[position].body
    }

    override fun getItemCount() = posts.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postTitleTxt: TextView = itemView.findViewById(R.id.post_title_txt)
        val postShortDescTxt: TextView = itemView.findViewById(R.id.post_short_desc_txt)
    }

    fun submitList(list: List<Post>) {
        posts.addAll(list)
        notifyDataSetChanged()
    }
}