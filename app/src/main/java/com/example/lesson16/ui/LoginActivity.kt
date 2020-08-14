package com.example.lesson16.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson16.MyApp
import com.example.lesson16.R
import com.example.lesson16.data.DataBase
import com.example.lesson16.data.LoginDataClass
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var db: DataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        db = MyApp.app?.getDB()
        setupListeners()
        setupViews()
    }

    private fun setupListeners() {
        btnEnter.setOnClickListener {
            if(isEtNotEmpty()){
                db?.loginDao()?.insertLoginData(LoginDataClass(
                    id = 1,
                    login = etLogin.text.toString(),
                    password = etPassword.text.toString())
                )
                startActivity(Intent(this, DataBaseActivity::class.java))
        } else {
                Toast.makeText(this, "Введите верные данные", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setupViews(){

        val result = db?.loginDao()?.getAllUsers()

        if (result!=null && result.isNotEmpty()) {
            val data = result.first()
            etLogin.setText(data?.login)
            etPassword.setText(data?.password)
        } else {
            Toast.makeText(this, "Нет данных для отображения", Toast.LENGTH_LONG).show()
        }
    }

    private fun isEtNotEmpty():Boolean {
        val resultLogin = etLogin.text.toString().length>6
        val resultPassword = etPassword.text.toString().length>7
        return resultLogin && resultPassword
    }
}