package com.example.mvvm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.databinding.ResLiveItemBinding
import com.example.mvvm.models.Live
import com.example.mvvm.viewholders.MainViewHolder

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    private var lives: List<Live> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ResLiveItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount() = lives.size


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) =
        holder.bind(lives[position])


    fun setLiveList(lives: List<Live>) {
        this.lives = lives.toMutableList()
        notifyDataSetChanged()
    }
}

