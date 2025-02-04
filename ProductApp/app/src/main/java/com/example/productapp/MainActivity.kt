package com.example.productapp

import android.os.Bundle
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        val adapter = ProductsAdapter(fillData())
        binding.recyclerView.adapter = adapter
    }
}

@Parcelize
data class Products(
    val name: String,
    val drawable: Int,
    val price: Double,
    val size: Int,
    val seller: String) : Parcelable

fun fillData(): List<Products> {
    return listOf(
        Products("Apple iPhone 16", R.drawable.apple, 5499.00, 128, "Fast Shop" ),
        Products("Google Pixel 9", R.drawable.google, 3700.99, 128, "techINN" ),
        Products("OnePlus 13", R.drawable.oneplus, 4178.45, 256, "AliExpress" ),
        Products("Samsung Galaxy S25", R.drawable.samsung,6299.10, 256, "Shop Samsung" ),
        Products("Xiaomi 15", R.drawable.xiaomi, 4591.77, 512, "AliExpress" )
    )
}
