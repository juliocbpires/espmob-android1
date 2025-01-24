package com.example.meuapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
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

        val movie1 = findViewById<ImageView>(R.id.movieBanner)
        val movie2 = findViewById<ImageView>(R.id.highlight1)
        val movie3 = findViewById<ImageView>(R.id.highlight2)
        val movie4 = findViewById<ImageView>(R.id.highlight3)
        val movie5 = findViewById<ImageView>(R.id.original1)
        val movie6 = findViewById<ImageView>(R.id.original2)
        val movie7 = findViewById<ImageView>(R.id.original3)

        setClickListener(movie1)
        setClickListener(movie2)
        setClickListener(movie3)
        setClickListener(movie4)
        setClickListener(movie5)
        setClickListener(movie6)
        setClickListener(movie7)

        val profileIcon = findViewById<ImageView>(R.id.navProfile)

        profileIcon.setOnClickListener {
            val intent = Intent(this, ProfileSelectionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setClickListener(imageView: ImageView) {
        imageView.setOnClickListener {
            val intent = Intent(this, MovieDetailActivity::class.java)
            startActivity(intent)
        }
    }
}
