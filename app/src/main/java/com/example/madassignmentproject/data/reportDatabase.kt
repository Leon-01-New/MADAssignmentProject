package com.example.madassignmentproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.greenwizard.data.dumpreports
import com.example.greenwizard.data.recyclepoint
import com.example.greenwizard.data.reportDao

@Database(entities = [dumpreports::class, recyclepoint::class], version = 1, exportSchema = false)
abstract class reportDatabase : RoomDatabase() {
    abstract fun reportDao(): reportDao

    companion object {
        @Volatile
        private var INSTANCE: reportDatabase? = null

        fun getDatabase(context: Context): reportDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    reportDatabase::class.java,
                    "report_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
