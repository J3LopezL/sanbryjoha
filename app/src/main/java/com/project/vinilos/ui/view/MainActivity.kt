package com.project.vinilos.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.project.vinilos.R
import com.project.vinilos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val collectorButton = findViewById<Button>(R.id.collector_button)
        collectorButton.setOnClickListener{
            val intent = Intent(this, AlbumsListActivity::class.java)
            startActivity(intent)
        }

        val visitorButton = findViewById<Button>(R.id.visitor_button)
        visitorButton.setOnClickListener{
            val intent = Intent(this, AlbumsListActivity::class.java)
            startActivity(intent)
        }
    }
}