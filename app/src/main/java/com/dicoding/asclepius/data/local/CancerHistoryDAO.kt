package com.dicoding.asclepius.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CancerHistoryDAO {
    @Insert
    suspend fun insert(cHistory: CancerHistoryEntity)

    @Query("select * from cancer_history")
    suspend fun getAllHistory(): List<CancerHistoryEntity>
}