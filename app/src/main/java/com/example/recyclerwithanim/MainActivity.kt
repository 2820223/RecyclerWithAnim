package com.example.recyclerwithanim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.Callback
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.recyclerwithanim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mahsulotlarAdapter = ProductsAdapter(this, Product(), Callback)
        var layoutManager = GridLayoutManager(this, 2)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = mahsulotlarAdapter
    }

    private fun Product(): MutableList<Products> {
        val mahlist = mutableListOf<Products>()
        for (i in 0..5){
            mahlist.add(Products(R.drawable.img, "Salad", "+$0.79"))
            mahlist.add(Products(R.drawable.img2, "Burger", "+$0.59"))
            mahlist.add(Products(R.drawable.img3, "Salad", "+$0.29"))
            mahlist.add(Products(R.drawable.img4, "Burger", "+$0.99"))
            mahlist.add(Products(R.drawable.img5, "Steak", "+$1.79"))
        }
        return mahlist
    }
}