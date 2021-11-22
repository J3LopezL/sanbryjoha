package com.project.vinilos.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.vinilos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.collectorButton.setOnClickListener {
            val intent = Intent(this, AlbumsListActivity::class.java)
            startActivity(intent)
        }

        binding.visitorButton.setOnClickListener {
            val intent = Intent(this, AlbumsListActivity::class.java)
            startActivity(intent)
        }

    }
}