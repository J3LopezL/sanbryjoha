package com.project.vinilos.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.project.vinilos.R
import com.project.vinilos.databinding.ActivityAlbumFormBinding
import com.project.vinilos.model.data.repositories.AlbumRepository
import com.project.vinilos.viewmodel.AlbumViewModel
import retrofit2.Response
import java.sql.Time
import java.sql.Timestamp
import java.time.Instant

class AlbumFormActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAlbumFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Vinilos App"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val genres = binding.editAlbumGenre
        val genresList = resources.getStringArray(R.array.genres)
        val genresAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genresList)
        genres.adapter = genresAdapter

        val labels = binding.editAlbumRecordLabel
        val labelsList = resources.getStringArray(R.array.recordLabels)
        val labelsAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, labelsList)
        labels.adapter = labelsAdapter

        val viewModel = AlbumViewModel()
        val albumName = binding.editTextAlbumName
        val albumCover = binding.editTextAlbumCover
        val releaseDate = binding.editTextAlbumReleaseDate
        releaseDate.setMaxLength(4)
        val albumDescription = binding.editTextAlbumDescription
        val albumGenre = binding.editAlbumGenre
        val albumRecordLabel = binding.editAlbumRecordLabel

        binding.buttonSaveAlbum.setOnClickListener {
            val parameters = HashMap<String,String>()
            parameters["name"] = albumName.text.toString()
            parameters["cover"] = albumCover.text.toString()
            parameters["releaseDate"] = releaseDate.text.toString()
            parameters["description"] = albumDescription.text.toString()
            parameters["genre"] = albumGenre.selectedItem.toString()
            parameters["recordLabel"] = albumRecordLabel.selectedItem.toString()

            if (inValidForm(parameters)) {
                Toast.makeText(this, R.string.invalid_form, Toast.LENGTH_SHORT).show()
            } else {
                parameters["releaseDate"] = Timestamp(releaseDate.text.toString().toInt(), 1,1,0,0,0,0).toString()
                viewModel.createAlbum(parameters)
            }
        }

        viewModel.albumResponse.observe(this, Observer {
            if (it.isSuccessful){
                val intent = Intent(this, AlbumsListActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, R.string.error_creating_album, Toast.LENGTH_SHORT).show()
            }
        })
    }

    // extension function to set edit text maximum length
    fun EditText.setMaxLength(maxLength: Int){
        filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
    }

    private fun inValidForm(parameters: HashMap<String, String>): Boolean {
         val isEverythingOK = parameters["name"] != "" &&
                parameters["cover"] != "" &&
                parameters["releaseDate"] != "" &&
                parameters["description"] != "" &&
                parameters["genre"] != "" &&
                parameters["recordLabel"] != ""

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