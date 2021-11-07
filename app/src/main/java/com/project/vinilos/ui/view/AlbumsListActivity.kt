package com.project.vinilos.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import java.io.Serializable
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.vinilos.data.models.Album
import com.project.vinilos.databinding.ActivityAlbumsListBinding
import com.project.vinilos.ui.viewmodel.AlbumViewModel
import androidx.appcompat.widget.Toolbar
import com.project.vinilos.R


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

        albumViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        albumViewModel.album.observe(this, Observer {
            adapter.albums = it
            adapter.notifyDataSetChanged()
        })

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