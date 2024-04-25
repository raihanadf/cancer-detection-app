package com.dicoding.asclepius.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dicoding.asclepius.data.adapter.HistoryAdapter
import com.dicoding.asclepius.data.adapter.NewsAdapter
import com.dicoding.asclepius.data.local.CancerHistoryEntity
import com.dicoding.asclepius.data.model.ArticlesItem
import com.dicoding.asclepius.databinding.ActivityHistoryBinding
import com.dicoding.asclepius.factory.ViewModelFactory
import com.dicoding.asclepius.viewmodel.HistoryViewModel

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private lateinit var historyViewModel: HistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        historyViewModel = obtainViewModel()

        historyViewModel.history.observe(this) {
            showRecyclerView(it)
        }
    }

    fun showRecyclerView(data: List<CancerHistoryEntity>) {
        val listAdapter = HistoryAdapter(data)
        binding.rvHistory.adapter = listAdapter
        binding.rvHistory.layoutManager = LinearLayoutManager(this)
        binding.rvHistory.setHasFixedSize(true)
    }

    private fun obtainViewModel(): HistoryViewModel {
        val factory = ViewModelFactory.getAppInstance(application)
        return ViewModelProvider(this, factory)[HistoryViewModel::class.java]
    }
}