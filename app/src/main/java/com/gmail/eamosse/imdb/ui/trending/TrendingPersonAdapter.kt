package com.gmail.eamosse.imdb.ui.trending

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.TrendingPerson
import com.gmail.eamosse.imdb.databinding.TrendingItemPersonBinding

class TrendingPersonAdapter(
    private val items: List<TrendingPerson>
) :
    RecyclerView.Adapter<TrendingPersonAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: TrendingItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TrendingPerson) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(TrendingItemPersonBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}