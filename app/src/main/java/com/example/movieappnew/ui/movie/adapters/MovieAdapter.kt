package com.example.movieappnew.ui.movie.adapters

import android.content.Context
import android.media.AudioManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieappnew.core.BaseViewHolder
import com.example.movieappnew.data.model.Movie
import com.example.movieappnew.databinding.MovieItemBinding
import org.imaginativeworld.whynotimagecarousel.OnItemClickListener


class MovieAdapter (private val moviesList: List<Movie>,
                    private val itemClickListener: OnMovieClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnMovieClickListener {
        fun onMovieClick(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBiding =
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            val holder = MoviesViewHolder(itemBiding, parent.context)

            itemBiding.root.setOnClickListener {
                val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION}
                        ?: return@setOnClickListener
                itemClickListener.onMovieClick(moviesList[position])
            }
            return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder){
            is MoviesViewHolder -> holder.bind(moviesList[position])
        }
    }

    override fun getItemCount(): Int = moviesList.size

    private  inner class MoviesViewHolder(
        val binding: MovieItemBinding,
        val context: Context
        ): BaseViewHolder<Movie>(binding.root){
        override fun bind(item: Movie) {
            Glide.with(context).load("https://image.tmdb.org/t/p/w500/${item.poster_path}").centerCrop().into(binding.imgMovie)

        }
    }
}