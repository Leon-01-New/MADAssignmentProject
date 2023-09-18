package com.example.greenwizard.data

import androidx.lifecycle.LiveData

class reportRepository (private val reportDao: reportDao){

    val readAllData: LiveData<List<dumpreports>> = reportDao.readAllData()
    val readAllRecycleData: LiveData<List<recyclepoint>> = reportDao.readAllRecycleData()

    // Insert data into the database
    fun addReport(dumpreports: dumpreports) {
        reportDao.addReport(dumpreports)
    }

    fun addRecycle(recyclepoint: recyclepoint) {
        reportDao.addRecycle(recyclepoint)
    }

}

