package com.example.lesson16.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLoginData(data: LoginDataClass)

    @Query("SELECT * FROM LoginDataClass WHERE login = :loginText AND password =:passwordText")
    fun getUser(loginText:String, passwordText:String):LoginDataClass

    @Query("SELECT * FROM LoginDataClass")
    fun getAllUsers():List<LoginDataClass>
}