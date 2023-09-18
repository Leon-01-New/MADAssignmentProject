package com.example.greenwizard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dumpreports")
data class dumpreports (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val address: String,
    val datetime: String,
    val typeofwaste: String,
    val status: String
)

@Entity(tableName = "recyclepoint")
data class recyclepoint (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val address: String
)
