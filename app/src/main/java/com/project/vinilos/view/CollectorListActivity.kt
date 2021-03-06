package com.project.vinilos.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.vinilos.R
import com.project.vinilos.databinding.ActivityCollectorListBinding
import com.project.vinilos.model.data.models.dataClass.Collector
import com.project.vinilos.viewmodel.CollectorViewModel
import java.io.Serializable

class CollectorListActivity : AppCompatActivity(), CollectorsAdapter.OnItemClickListener {
    private lateinit var binding : ActivityCollectorListBinding
    private val collectorViewModel: CollectorViewModel by viewModels()
    private lateinit var adapter:CollectorsAdapter
    private val collectorList = mutableListOf<Collector>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollectorListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        collectorViewModel.onCreate()


        collectorViewModel.collectorModelLiveData.observe(this, { currentCollector ->
            adapter.collector = currentCollector
            adapter.notifyDataSetChanged()
        })

        onCollectorsClick()

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Vinilos App"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initRecyclerView(){
        adapter = CollectorsAdapter(collectorList, this)
        binding.rvCollector.layoutManager = LinearLayoutManager(this)
        binding.rvCollector.adapter = adapter
    }

    private fun onCollectorsClick() {
        binding.buttonFooterNavigation.setOnNavigationItemReselectedListener{
            when (it.itemId) {
                R.id.ic_artists -> intent = Intent(this, PerformersListActivity::class.java)
                R.id.ic_albums -> intent = Intent(this, AlbumsListActivity::class.java)
                else -> { // Note the block
                    print("No item selected or user is currently on this activity")
                }
            }
            startActivity(intent)
        }
    }

    override fun onItemClick(collector: Collector) {
        val intent = Intent(this, CollectorDetailsActivity::class.java)
        intent.putExtra("collectorSelected", collector as Serializable)
        intent.putExtra("idCollectorSelected", adapter.index as Serializable)
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