package com.project.vinilos.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.project.vinilos.R
import com.project.vinilos.databinding.ActivityAddTracksAlbumBinding
import com.project.vinilos.model.core.RetrofitHelper
import com.project.vinilos.model.data.models.dataClass.Album
import com.project.vinilos.model.data.models.dataClass.Tracks
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_add_tracks_album.*
import kotlinx.android.synthetic.main.item_input_track.*
import java.io.Serializable
import kotlinx.serialization.json.Json

class AddTracksAlbumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTracksAlbumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTracksAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var album = intent.extras?.get("extra_object") as Album

        val etTrackName = binding.scTracksAlbum.itemInputTrack.etTrackName
        val etMinutes = binding.scTracksAlbum.itemInputTrack.etMinutes
        val etSeconds = binding.scTracksAlbum.itemInputTrack.etSeconds
        val idAlbum = album.id.toString()

        Picasso.get().load(album.cover)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(ivAlbumTrack)

        val title = binding.scTracksAlbum.tvTrackAlbumTitle
        title.text = album.name

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Vinilos App"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.scTracksAlbum.bAddTracks.setOnClickListener {
            val url = RetrofitHelper.getRetrofit().baseUrl().toString() + "albums/" + idAlbum + "/tracks"
            val queue=Volley.newRequestQueue(this)
            val resultPost= object : StringRequest(
                Method.POST,
                url,
                Response.Listener<String> {  it ->
                    val trackResponse = Gson().fromJson(it, Tracks::class.java)
                    Toast.makeText(this, "Canción Asociada existosamente", Toast.LENGTH_SHORT).show()
                    album.tracks = album.tracks + trackResponse

                    val intent = Intent(this, AlbumDetailsActivity::class.java)
                    intent.putExtra("extra_object", album as Serializable)
                    startActivity(intent)
                },

                Response.ErrorListener { error ->
                    Toast.makeText(this, "Error $error", Toast.LENGTH_SHORT).show()
                }
            ){
                override fun getParams(): MutableMap<String, String> {
                    val parameters=HashMap<String,String>()
                    parameters.put("name", etTrackName?.text.toString())
                    parameters.put("duration", etMinutes?.text.toString() + " : " + etSeconds?.text.toString())
                    return parameters
                }
            }

            queue.add(resultPost)
        }

        binding.scTracksAlbum.bCancelTracks.setOnClickListener {
            val intent = Intent(this, AlbumDetailsActivity::class.java)
            intent.putExtra("extra_object", album as Serializable)
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
