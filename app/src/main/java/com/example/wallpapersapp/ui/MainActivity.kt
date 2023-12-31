package com.example.wallpapersapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wallpapersapp.R
import com.example.wallpapersapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_WallpapersApp)
        setContentView(binding.root)
    }
}