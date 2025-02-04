package com.example.productapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter: ArrayAdapter<*>
        val products = arrayOf("Samsung Galaxy S25", "Google Pixel 9", "OnePlus 13", "Apple iPhone 16", "Xiaomi 15")
        var mListView = findViewById<ListView>(R.id.lstProducts)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, products)
        mListView.adapter = adapter

        mListView.setOnItemClickListener { parent, view, position, id ->
            val element = parent.getItemAtPosition(position) as String
            Toast.makeText(this,"Toque Realizado - $element",Toast.LENGTH_SHORT).show()
        }
    }
}
