package com.example.lesson16.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ETDao {

    @Insert
    fun insertData(data:DataClass)

    @Query("SELECT * FROM DataClass")
    fun getData():List<DataClass>
}