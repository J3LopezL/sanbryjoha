package com.project.vinilos.view

import android.content.Intent
import android.os.Bundle
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

class AddTracksAlbumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTracksAlbumBinding
    var idAlbum:String?=null
    var etTrackName:EditText?=null
    var etMinutes:EditText?=null
    var etSeconds:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTracksAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var album = intent.extras?.get("extra_object") as Album
        etTrackName=findViewById(R.id.etTrackName)
        etMinutes=findViewById(R.id.etMinutes)
        etSeconds=findViewById(R.id.etSeconds)
        idAlbum= album.id.toString()
        Picasso.get().load(album.cover)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(ivAlbumTrack)
        val title = findViewById<TextView>(R.id.tvTrackAlbumTitle)
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
                Toast.makeText(this, "Canción Asociada existosamente", Toast.LENGTH_SHORT).show()
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
        val song = Tracks(500,etTrackName?.text.toString(),etMinutes?.text.toString() + " : " + etSeconds?.text.toString())
        val intent = Intent(this, AlbumDetailsActivity::class.java)
        intent.putExtra("extra_object", album as Serializable)
        startActivity(intent)
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
