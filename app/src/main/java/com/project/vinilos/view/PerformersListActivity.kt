package com.project.vinilos.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.vinilos.R
import com.project.vinilos.databinding.ActivityPerformersListBinding
import com.project.vinilos.model.data.models.dataClass.Performer
import com.project.vinilos.viewmodel.PerformerViewModel
import java.io.Serializable

class PerformersListActivity : AppCompatActivity(), PerformersAdapter.OnItemClickListener {
    private lateinit var binding : ActivityPerformersListBinding
    private val performerViewModel: PerformerViewModel by viewModels()

    private lateinit var adapter:PerformersAdapter
    private val performersList = mutableListOf<Performer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerformersListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        performerRecyclerView()
        onCollectorsClick()
        performerViewModel.onCreate()

        performerViewModel.performer.observe(this, { currentPerformer ->
            adapter.performers = currentPerformer
            adapter.notifyDataSetChanged()
        })

        performerViewModel.isLoading.observe(this, {
            binding.progress.isVisible = it
        })

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Vinilos App"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun performerRecyclerView(){
        adapter = PerformersAdapter(performersList, this)
        binding.rvPerformers.layoutManager = LinearLayoutManager(this)
        binding.rvPerformers.adapter = adapter
    }

    private fun onCollectorsClick() {
        binding.buttonFooterNavigation.setOnNavigationItemReselectedListener{

            when (it.itemId) {
                R.id.ic_collecotrs ->  intent = Intent(this, CollectorListActivity::class.java)
                R.id.ic_albums -> intent = Intent(this, AlbumsListActivity::class.java)
                else -> { // Note the block
                    print("No item selected or user is currently on this activity")
                }
            }
            startActivity(intent)
        }
    }

    override fun onItemClick(performer: Performer) {
        val intent = Intent(this, PerformerDetailsActivity::class.java)
        intent.putExtra("extra_object", performer as Serializable)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.logout) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}

