package com.example.lesson16.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataClass (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var etTitle: String = "",
    var etDesc: String = ""
)