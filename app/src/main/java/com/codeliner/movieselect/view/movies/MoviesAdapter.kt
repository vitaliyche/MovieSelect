package com.codeliner.movieselect.view.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codeliner.movieselect.R
import com.codeliner.movieselect.model.MovieResult
import kotlinx.android.synthetic.main.item_movies.view.*

val callback = object : DiffUtil.ItemCallback<MovieResult>() {
    override fun areItemsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
        return oldItem.link.url == newItem.link.url
    } //это точно такой же элемент или нет

    override fun areContentsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean {
        return oldItem == newItem
    } // есть ли различия внутри элемента
}

class MoviesAdapter : PagingDataAdapter<MovieResult, MoviesAdapter.MyViewHolder>(callback) {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.itemView.item_tv_title.text = item.display_title
        holder.itemView.item_tv_description.text = item.summary_short
        val context = holder.itemView.context

        Glide.with(context)
            .load(item.multimedia.src)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.item_img_movie)
    }

} //в PagingDataAdapter уже зашит список, не нужно создавать и обновлять. Обновляется через submitData