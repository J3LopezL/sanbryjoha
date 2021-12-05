package com.project.vinilos.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.project.vinilos.R
import com.project.vinilos.databinding.ActivityAddTracksAlbumBinding
import com.project.vinilos.model.data.models.dataClass.Album
import com.project.vinilos.viewmodel.TrackViewModel
import java.io.Serializable

class AddTracksAlbumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTracksAlbumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTracksAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val album = intent.extras?.get("extra_object") as Album

        val etTrackName = binding.etTrackName
        val etMinutes = binding.etMinutes
        val etSeconds = binding.etSeconds
        val albumId = album.id

        val title = binding.tvTrackAlbumTitle
        title.text = album.name

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Vinilos App"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = TrackViewModel()

        binding.bAddTracks.setOnClickListener {
            val parameters = HashMap<String,String>()
            parameters["name"] = etTrackName.text.toString()
            parameters["duration"] = etMinutes.text.toString() + " : " + etSeconds.text.toString()

            if (inValidForm(parameters)) {
                Toast.makeText(this, R.string.invalid_form, Toast.LENGTH_SHORT).show()
            } else {
                viewModel.createTrack(parameters, albumId)
            }
        }

        viewModel.trackResponse.observe(this, {
            if (it.isSuccessful){
                val trackResponse = it.body()
                Toast.makeText(this, R.string.track_associated, Toast.LENGTH_SHORT).show()
                album.tracks = album.tracks + trackResponse!!

                val intent = Intent(this, AlbumDetailsActivity::class.java)
                intent.putExtra("extra_object", album as Serializable)
                startActivity(intent)
            }else{
                Toast.makeText(this, R.string.error_creating_track, Toast.LENGTH_SHORT).show()
            }
        })

        binding.bCancelTracks.setOnClickListener {
            val intent = Intent(this, AlbumDetailsActivity::class.java)
            intent.putExtra("extra_object", album as Serializable)
            startActivity(intent)
        }
    }

    private fun inValidForm(parameters: HashMap<String, String>): Boolean {
        val isEverythingOK = parameters["name"] != "" &&
                parameters["duration"] != ""

        return !isEverythingOK
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
