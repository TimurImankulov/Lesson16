package com.example.lesson16.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lesson16.MyApp
import com.example.lesson16.R
import com.example.lesson16.data.DataBase
import com.example.lesson16.data.DataClass
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private var db: DataBase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setupListeners()
        db = MyApp.app?.getDB()

    }

    private fun setupListeners() {
        btnSave.setOnClickListener {
            db?.getDao()?.insertData(fetchData())
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun fetchData():DataClass{
        return DataClass(
            etTitle = etTitle.text.toString(),
            etDesc = etDesc.text.toString()
        )
    }
}