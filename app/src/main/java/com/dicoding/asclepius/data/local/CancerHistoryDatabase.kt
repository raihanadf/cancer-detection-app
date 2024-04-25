package com.dicoding.asclepius.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CancerHistoryEntity::class], version = 1)
abstract class CancerHistoryDatabase : RoomDatabase() {
    abstract fun cancerHistoryDAO(): CancerHistoryDAO

    companion object {
        @Volatile
        private var INSTANCE: CancerHistoryDatabase? = null

        fun getDatabase(context: Context): CancerHistoryDatabase {
            if (INSTANCE == null) {
                synchronized(CancerHistoryDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CancerHistoryDatabase::class.java, "cancer_db"
                    ).build()
                }
            }
            return INSTANCE as CancerHistoryDatabase
        }
    }

}