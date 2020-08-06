package com.example.lesson16.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson16.MyApp
import com.example.lesson16.R
import com.example.lesson16.data.DataBase
import com.example.lesson16.data.DataClass
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    val adapter = RecyclerviewAdapter()
    private var db: DataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = MyApp.app?.getDB()

        setupView()
        setupRecyclerView()
    }

    private fun setupView() {
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun setupRecyclerView() {
        recyclerView?.adapter = adapter
        val data = db?.getDao()?.getData()
        if (data!=null)
        adapter.update(data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add -> startActivity(Intent(this, SecondActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}