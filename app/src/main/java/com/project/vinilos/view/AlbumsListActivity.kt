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
import com.project.vinilos.databinding.ActivityAlbumsListBinding
import com.project.vinilos.model.data.models.dataClass.Album
import com.project.vinilos.viewmodel.AlbumViewModel
import java.io.Serializable


class AlbumsListActivity : AppCompatActivity(), AlbumsAdapter.OnItemClickListener {
    private lateinit var binding : ActivityAlbumsListBinding
    private val albumViewModel: AlbumViewModel by viewModels()

    private lateinit var adapter:AlbumsAdapter
    private val albumsList = mutableListOf<Album>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumsListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        albumViewModel.onCreate()

        albumViewModel.isLoading.observe(this, {
            binding.loading.isVisible = it
        })

        albumViewModel.album.observe(this, {
            adapter.albums = it
            adapter.notifyDataSetChanged()
        })
        onCollectorsClick()

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Vinilos App"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initRecyclerView(){
        adapter = AlbumsAdapter(albumsList, this)
        binding.rvAlbums.layoutManager = LinearLayoutManager(this)
        binding.rvAlbums.adapter = adapter
    }

    private fun onCollectorsClick() {
        binding.buttonFooterNavigation.setOnNavigationItemReselectedListener{

            when (it.itemId) {
                R.id.ic_collecotrs ->  intent = Intent(this, CollectorListActivity::class.java)
                R.id.ic_artists -> intent = Intent(this, PerformersListActivity::class.java)
                else -> { // Note the block
                    print("No item selected or user is currently on this activity")
                }
            }
            startActivity(intent)
        }
    }

    override fun onItemClick(album: Album) {
        val intent = Intent(this, AlbumDetailsActivity::class.java)
        intent.putExtra("extra_object", album as Serializable)
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