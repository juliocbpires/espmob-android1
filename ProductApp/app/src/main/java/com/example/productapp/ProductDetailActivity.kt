package com.example.productapp
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_product)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val product = intent.getParcelableExtra("product", Products::class.java)

        product?.let {
            findViewById<ImageView>(R.id.product_image).setImageResource(it.drawable)
            findViewById<TextView>(R.id.product_name).text = it.name
            findViewById<TextView>(R.id.product_size).text = "${it.size} GB"
            findViewById<TextView>(R.id.product_price).text = "R$ ${it.price}"
            findViewById<TextView>(R.id.product_seller).text = it.seller
        }

        findViewById<ImageView>(R.id.back_arrow).setOnClickListener {
            finish()
        }
    }
}
