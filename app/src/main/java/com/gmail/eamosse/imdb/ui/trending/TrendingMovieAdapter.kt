package com.gmail.eamosse.imdb.ui.trending

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.Trending
import com.gmail.eamosse.imdb.databinding.TrendingItemMovieBinding

class TrendingMovieAdapter(
    private val items: List<Trending>
) : RecyclerView.Adapter<TrendingMovieAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: TrendingItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Trending) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(TrendingItemMovieBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

}