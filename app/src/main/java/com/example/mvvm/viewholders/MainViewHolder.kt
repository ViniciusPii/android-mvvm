package com.example.mvvm.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.databinding.ResLiveItemBinding
import com.example.mvvm.models.Live

class MainViewHolder(
    private val binding: ResLiveItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(live: Live) {
        binding.itemTitle.text = live.title
        binding.itemAuthor.text = live.author
    }
}