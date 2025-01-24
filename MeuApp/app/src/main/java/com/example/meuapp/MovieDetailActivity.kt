package com.example.meuapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.movieDetail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val homeIcon = findViewById<ImageView>(R.id.navHome)

        homeIcon.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val profileIcon = findViewById<ImageView>(R.id.navProfile)

        profileIcon.setOnClickListener {
            val intent = Intent(this, ProfileSelectionActivity::class.java)
            startActivity(intent)
        }
    }
}
