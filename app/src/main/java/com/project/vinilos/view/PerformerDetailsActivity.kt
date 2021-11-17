package com.project.vinilos.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.vinilos.R
import com.project.vinilos.databinding.ActivityAlbumDetailsBinding
import com.project.vinilos.databinding.ActivityPerformerDetailsBinding
import com.project.vinilos.model.data.models.dataClass.Album
import com.project.vinilos.model.data.models.dataClass.Performer
import com.project.vinilos.model.data.models.dataClass.Tracks
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import java.io.Serializable
import java.text.SimpleDateFormat

class PerformerDetailsActivity : AppCompatActivity(), AlbumsAdapter.OnItemClickListener {
    private lateinit var binding: ActivityPerformerDetailsBinding
    private lateinit var adapter:AlbumsAdapter
    private val albumsList = mutableListOf<Album>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerformerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        onCollectorsClick()

        val performer = intent.extras?.get("extra_object") as Performer
        for(album in performer.albums){
            albumsList.add(album)
        }

        setSupportActionBar(findViewById(R.id.performerToolbar))
        Picasso.get().load(performer.image)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(binding.bgPerformerImage)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = findViewById<TextView>(R.id.tvPerformerDetailsName)
        title.text = performer.name

        val description = findViewById<TextView>(R.id.tvPerformerDetailsBirthday)
        description.text = performer.birthDate.substring(0,10)

        val artist = findViewById<TextView>(R.id.tvPerformerDetailsDescription)
        artist.text = performer.description
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

    private fun initRecyclerView(){
        adapter = AlbumsAdapter(albumsList, this)
        binding.scAlbumsList.rvAlbums.layoutManager = LinearLayoutManager(this)
        binding.scAlbumsList.rvAlbums.adapter = adapter
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

    override fun onItemClick(album: Album) {

    }
}