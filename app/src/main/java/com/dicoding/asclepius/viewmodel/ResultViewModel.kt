package com.dicoding.asclepius.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.asclepius.data.local.CancerHistoryEntity
import com.dicoding.asclepius.repository.HistoryRepository
import kotlinx.coroutines.launch

class ResultViewModel(mApplication: Application) : ViewModel() {
    private val mHistoryRepository: HistoryRepository =
        HistoryRepository(mApplication)

    fun insert(cHistory: CancerHistoryEntity) {
        viewModelScope.launch {
            mHistoryRepository.insert(cHistory)
        }
    }
}