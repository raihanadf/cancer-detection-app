package com.dicoding.asclepius.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cancer_history")
data class CancerHistoryEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "imageUri")
    val imageUri: String,
    @ColumnInfo(name = "prediction")
    val prediction: String,
    @ColumnInfo(name = "confidenceScore")
    val confidenceScore: Float
)
