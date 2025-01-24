package com.example.meuapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profileSelection)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val profile1 = findViewById<ImageView>(R.id.profile1)
        val profile2 = findViewById<ImageView>(R.id.profile2)
        val profile3 = findViewById<ImageView>(R.id.profile3)
        val profile4 = findViewById<ImageView>(R.id.profile4)
        val profile5 = findViewById<ImageView>(R.id.profile5)
        val profile6 = findViewById<ImageView>(R.id.profile6)
        val profile7 = findViewById<ImageView>(R.id.profile7)

        setClickListener(profile1)
        setClickListener(profile2)
        setClickListener(profile3)
        setClickListener(profile4)
        setClickListener(profile5)
        setClickListener(profile6)
        setClickListener(profile7)
    }

    private fun setClickListener(imageView: ImageView) {
        imageView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
