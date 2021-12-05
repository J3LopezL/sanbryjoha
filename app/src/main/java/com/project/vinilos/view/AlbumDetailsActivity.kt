package com.project.vinilos.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.vinilos.R
import com.project.vinilos.databinding.ActivityAlbumDetailsBinding
import com.project.vinilos.model.data.models.dataClass.Album
import com.project.vinilos.model.data.models.dataClass.Performer
import com.project.vinilos.model.data.models.dataClass.Tracks
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_scrolling_content.*
import java.io.Serializable

class AlbumDetailsActivity : AppCompatActivity() {

    private var itemSelect:String?=null
    private var itemImage:String?=null
    private lateinit var binding: ActivityAlbumDetailsBinding
    private lateinit var adapter:TracksAdapter
    private val tracksList = mutableListOf<Tracks>()
    private val performersList = mutableListOf<Performer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        onCollectorsClick()

        val album = intent.extras?.get("extra_object") as Album
        for(track in album.tracks){
            tracksList.add(track)
        }

        addTracks.setOnClickListener {
            val intent = Intent(this, AddTracksAlbumActivity::class.java)
            intent.putExtra("extra_object", album as Serializable)
            startActivity(intent)
        }

        for(performer in album.performers){
            performersList.add(performer)
        }

        Picasso.get().load(album.cover)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(binding.bgAlbumImage)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = findViewById<TextView>(R.id.tvAlbumDetailsTitle)
        title.text = album.name

        val description = findViewById<TextView>(R.id.tvAlbumDetailsDescription)
        description.text = album.description

        val artist = findViewById<TextView>(R.id.tvAlbumDetailsArtist)
        artist.text = album.recordLabel

        itemSelect = album.id.toString()
        itemImage = album.cover
    }

    private fun initRecyclerView(){
        adapter = TracksAdapter(tracksList, performersList)
        binding.scTracksList.rvTracks.layoutManager = LinearLayoutManager(this)
        binding.scTracksList.rvTracks.adapter = adapter
    }

    private fun onCollectorsClick() {
        binding.buttonFooterNavigation.setOnNavigationItemReselectedListener{

            when (it.itemId) {
                R.id.ic_collecotrs ->  intent = Intent(this, CollectorListActivity::class.java)
                R.id.ic_artists -> intent = Intent(this, PerformersListActivity::class.java)
                R.id.ic_albums -> intent = Intent(this, AlbumsListActivity::class.java)
                else -> { // Note the block
                    print("No item selected")
                }
            }
            startActivity(intent)
        }
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