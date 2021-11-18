package com.project.vinilos.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.vinilos.R
import com.project.vinilos.databinding.ActivityCollectorListBinding
import com.project.vinilos.model.data.models.dataClass.Collector
import com.project.vinilos.viewmodel.CollectorViewModel

class CollectorListActivity : AppCompatActivity(), CollectorAdapter.OnItemClickListener {
    private lateinit var binding : ActivityCollectorListBinding
    // conexión del view model a la activity
    private val collectorViewModel: CollectorViewModel by viewModels()
    private lateinit var adapter:CollectorAdapter
    private val collectorList = mutableListOf<Collector>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollectorListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        collectorViewModel.onCreate()


        collectorViewModel.collectorModelLiveData.observe(this, Observer { currentCollector ->
            adapter.collector = currentCollector
            adapter.notifyDataSetChanged()
        })

        onCollectorsClick()

        // barra de header
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Vinilos App"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initRecyclerView(){
        adapter = CollectorAdapter(collectorList, this)
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
        println("IR a la siguiente pagina al dar click en un item")
//        val intent = Intent(this, AlbumDetailsActivity::class.java)
//        intent.putExtra("extra_object", collector as Serializable)
//        startActivity(intent)
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