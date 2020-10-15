package com.app.poststestproject.ui.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.poststestproject.R
import com.app.poststestproject.data.model.Post

class PostsAdapter(
    private val posts: ArrayList<Post>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_posts_list_item, parent, false),
            onItemClickListener
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postTitleTxt.text = posts[position].title
        holder.postShortDescTxt.text = posts[position].body
    }

    override fun getItemCount() = posts.size

    inner class ViewHolder(itemView: View, private val onItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val postTitleTxt: TextView = itemView.findViewById(R.id.post_title_txt)
        val postShortDescTxt: TextView = itemView.findViewById(R.id.post_short_desc_txt)

        init {
            itemView.setOnClickListener(this)
            itemView.findViewById<ImageView>(R.id.iv_favorite).apply {
                setOnClickListener {
                    onItemClickListener.onFavoriteItemClick(adapterPosition)
                    if (!posts[adapterPosition].isFavorite) {
                        setBackgroundResource(R.drawable.ic_favorite_selected)
                    } else {
                        setBackgroundResource(R.drawable.ic_favorite_no_selected)
                    }
                }
            }
        }

        override fun onClick(v: View?) {
            onItemClickListener.onItemClick(posts[adapterPosition])
        }
    }

    fun submitList(list: List<Post>) {
        posts.addAll(list)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(post: Post)
        fun onFavoriteItemClick(position: Int)
    }
}