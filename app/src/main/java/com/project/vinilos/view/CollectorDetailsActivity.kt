package com.project.vinilos.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.vinilos.R
import com.project.vinilos.databinding.ActivityCollectorDetailsBinding
import com.project.vinilos.model.data.models.dataClass.Collector
import com.project.vinilos.model.data.models.dataClass.Comments
import com.project.vinilos.model.data.models.dataClass.Performer
import com.project.vinilos.viewmodel.CollectorViewModel

class CollectorDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCollectorDetailsBinding
    private val collectorViewModel: CollectorViewModel by viewModels()

    private lateinit var adapterComments: CommentsAdapter
    private lateinit var adapterFavoritePerformers: PerformerAdapter

    private val comments = mutableListOf<Comments>()
    private val favoritePerformers = mutableListOf<Performer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val collector = intent.extras?.get("collectorSelected") as Collector
        val idCollector = intent.extras?.get("idCollectorSelected") as Int
        setContentView(R.layout.activity_collector_details)
        binding = ActivityCollectorDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        collectorViewModel.collectorModelLiveData.observe(this, { collector ->
            println(collector[idCollector].favoritePerformers)
            adapterComments.comments = collector[idCollector].comments
            adapterFavoritePerformers.favoritePerformers = collector[idCollector].favoritePerformers
            adapterComments.notifyDataSetChanged()
            adapterFavoritePerformers.notifyDataSetChanged()
        })

        collectorViewModel.onCreate()
        onCollectorsClick()
        mapItems(collector)
        initRecyclerViewPerformer()
        initRecyclerViewComments()
    }


    private fun mapItems(collector: Collector) {
        val title = binding.nameCollector
        title.text = collector.name
        val telephone = binding.phoneCollector
        telephone.text = collector.telephone
        val email = binding.emailCollector
        email.text = collector.email

    }

    private fun initRecyclerViewComments(){
        adapterComments = CommentsAdapter(comments)
        binding.rvCommentsCollector.layoutManager = LinearLayoutManager(this)
        binding.rvCommentsCollector.adapter = adapterComments
    }

    private fun initRecyclerViewPerformer(){
        adapterFavoritePerformers = PerformerAdapter(favoritePerformers)
        binding.rvFavoritePerformers.layoutManager = LinearLayoutManager(this)
        binding.rvFavoritePerformers.adapter = adapterFavoritePerformers
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
}

