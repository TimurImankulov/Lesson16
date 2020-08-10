package com.example.lesson16.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataClass::class, LoginDataClass::class], version = 1)
abstract class DataBase:RoomDatabase() {
    abstract fun getDao():ETDao
    abstract fun loginDao():LoginDao
}