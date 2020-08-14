package com.example.lesson16.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoginDataClass(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,
    var login: String,
    var password: String
)