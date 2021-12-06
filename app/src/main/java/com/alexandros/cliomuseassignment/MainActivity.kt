package com.alexandros.cliomuseassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.alexandros.cliomuseassignment.api.responseModel.TourData
import com.alexandros.cliomuseassignment.viewmodels.ToursViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexandros.cliomuseassignment.databinding.ActivityMainBinding
import com.alexandros.cliomuseassignment.repositories.ToursRepository
import com.alexandros.cliomuseassignment.viewmodels.ViewModelFactory
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    private lateinit var toursViewModel: ToursViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var tour_Url :String




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        toursViewModel = ViewModelProvider(this, ViewModelFactory(ToursRepository)).get(ToursViewModel::class.java)
        toursViewModel.getToursFromRepository()


        setContentView(binding.root)

        observeAnyChange()


    }



    fun observeAnyChange() {
        toursViewModel.getToursFromRepository().observe(this, {
            binding.titleTextView.setText(it?.title)
            binding.ratingTextView.setText(it?.average_rating)
            binding.priceTextViewRight.setText(it?.retail_price)
            binding.durationTextViewRight.setText(it?.duration)
            Picasso.get().load(it.thumbnail).into(binding.tourImageView)
            tour_Url= it.permalink
            binding.audioTours.setOnClickListener {
                val intent: Intent = Intent.parseUri(tour_Url, 0)
                startActivity(intent)
            }
            Log.i("MAIN ACTIVITY", "observeAnyChange: "+it.duration)
        })
    }







}