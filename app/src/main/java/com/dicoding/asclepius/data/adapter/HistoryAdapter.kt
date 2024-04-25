package com.dicoding.asclepius.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.asclepius.data.local.CancerHistoryEntity
import com.dicoding.asclepius.databinding.ItemRowHistoryBinding

class HistoryAdapter(val history: List<CancerHistoryEntity>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    class HistoryViewHolder(val binding: ItemRowHistoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemRowHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = history.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.binding.predictionTxt.text = history[position].prediction
        holder.binding.confidenceTxt.text = history[position].confidenceScore.toString()
    }
}
