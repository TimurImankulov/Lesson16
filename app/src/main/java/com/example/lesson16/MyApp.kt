package com.example.lesson16

import android.app.Application
import androidx.room.Room
import com.example.lesson16.data.DataBase

class MyApp:Application() {

    private var db: DataBase? = null

    override fun onCreate() {
        super.onCreate()
        app = this
        db = Room.databaseBuilder(applicationContext, DataBase::class.java, DB_NAME)
            .allowMainThreadQueries()
            .build()
    }
    fun getDB():DataBase? = db

    companion object{
        var app: MyApp? = null
        private const val DB_NAME = "MY_DATABASE"
    }
}