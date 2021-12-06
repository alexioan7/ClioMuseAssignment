package com.alexandros.cliomuseassignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexandros.cliomuseassignment.api.responseModel.TourData
import com.alexandros.cliomuseassignment.repositories.ToursRepository

class ToursViewModel(private val toursRepo: ToursRepository): ViewModel() {

//    private val _tours = MutableLiveData<TourData>()
//    val tours: LiveData<TourData> get() = _tours


    fun requestToursFromRepository(){
        toursRepo.requestTours()
    }

    fun getToursFromRepository(): MutableLiveData<TourData> {
        requestToursFromRepository()
        return toursRepo.getToursFromRemoteData()
    }


}