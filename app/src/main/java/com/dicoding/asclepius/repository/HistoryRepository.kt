package com.dicoding.asclepius.repository

import android.app.Application
import com.dicoding.asclepius.data.local.CancerHistoryDAO
import com.dicoding.asclepius.data.local.CancerHistoryDatabase
import com.dicoding.asclepius.data.local.CancerHistoryEntity

class HistoryRepository(mApplication: Application) {
    private val mCancerDao: CancerHistoryDAO

    init {
        val db = CancerHistoryDatabase.getDatabase(mApplication)
        mCancerDao = db.cancerHistoryDAO()
    }

    suspend fun insert(cHistory: CancerHistoryEntity) {
        mCancerDao.insert(cHistory)
    }

    suspend fun getAllHistory(): List<CancerHistoryEntity> {
        return mCancerDao.getAllHistory()
    }
}