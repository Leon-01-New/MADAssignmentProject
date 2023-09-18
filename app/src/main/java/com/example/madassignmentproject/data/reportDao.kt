package com.example.greenwizard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface reportDao {
    @Insert
    fun addReport(dumpreports: dumpreports)

    @Query(value = "Select * FROM dumpreports ORDER BY id ASC")
    fun readAllData(): LiveData<List<dumpreports>>

    @Insert
    fun addRecycle(recyclepoint: recyclepoint )

    @Query(value = "Select * FROM recyclepoint ORDER BY id ASC")
    fun readAllRecycleData(): LiveData<List<recyclepoint>>
}
