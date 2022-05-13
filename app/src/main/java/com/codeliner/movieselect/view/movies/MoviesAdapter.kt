package com.codeliner.movieselect.view.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codeliner.movieselect.MAIN
import com.codeliner.movieselect.R
import com.codeliner.movieselect.model.MovieResult
import kotlinx.android.synthetic.main.item_movies.view.*

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    private var moviesList = emptyList<MovieResult>()

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.item_tv_title.text = moviesList[position].display_title
        holder.itemView.item_tv_description.text = moviesList[position].summary_short

        Glide.with(MAIN)
            .load(moviesList[position].multimedia)
            .fitCenter()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.item_img_movie)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun setList(list: List<MovieResult>) {
        moviesList = list
        notifyDataSetChanged()
    }
}