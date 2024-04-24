package com.dicoding.asclepius.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.dicoding.asclepius.R
import com.dicoding.asclepius.data.model.ArticlesItem
import com.dicoding.asclepius.databinding.ItemRowNewsBinding

class NewsAdapter(val articles: List<ArticlesItem?>?) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(val binding: ItemRowNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemRowNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = articles?.size!!

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.binding.imgPhoto.load(articles!![position]?.urlToImage)
        holder.binding.textTitle.text = articles!![position]?.title
        holder.binding.textDesc.text = articles!![position]?.content
    }
}