package com.dicoding.asclepius.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.asclepius.data.local.CancerHistoryEntity
import com.dicoding.asclepius.repository.HistoryRepository
import kotlinx.coroutines.launch

class HistoryViewModel(mApplication: Application) : ViewModel() {
    companion object {
        const val TAG = "HistoryVM"
    }

    private val mHistoryRepository: HistoryRepository = HistoryRepository(mApplication)

    private var _histories = MutableLiveData<List<CancerHistoryEntity>>()
    val history: LiveData<List<CancerHistoryEntity>> get() = _histories

    fun getAllHistory() {
        viewModelScope.launch {
            val result = mHistoryRepository.getAllHistory()
            _histories.value = result
            Log.d(TAG, "getAllHistory: ${history.value}")
        }
    }

    init {
        getAllHistory()
    }
}