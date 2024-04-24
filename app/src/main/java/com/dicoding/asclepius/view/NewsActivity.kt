package com.dicoding.asclepius.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dicoding.asclepius.R
import com.dicoding.asclepius.data.adapter.NewsAdapter
import com.dicoding.asclepius.data.model.ArticlesItem
import com.dicoding.asclepius.databinding.ActivityNewsBinding
import com.dicoding.asclepius.viewmodel.NewsViewModel

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    private val newsVM by viewModels<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_history -> {
                    startActivity(Intent(this, HistoryActivity::class.java))
                    true
                }

                else -> false

            }
        }

        binding.btnScan.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        newsVM.articles.observe(this) { article ->
            showRecyclerView(article)
        }

    }

    fun showRecyclerView(data: List<ArticlesItem?>?) {
        val listAdapter = NewsAdapter(data)
        binding.rvNews.adapter = listAdapter
        binding.rvNews.layoutManager =
            StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
    }
}