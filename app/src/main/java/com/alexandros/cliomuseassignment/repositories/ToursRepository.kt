package com.alexandros.cliomuseassignment.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.alexandros.cliomuseassignment.api.RetrofitBuilder
import com.alexandros.cliomuseassignment.api.responseModel.TourData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ToursRepository {
    private const val TAG = "ToursRepository"


    val tourDataFromRemoteData: MutableLiveData<TourData> = MutableLiveData()




    fun getToursFromRemoteData(): MutableLiveData<TourData> {
        return tourDataFromRemoteData
    }





    fun requestTours() {
        val dataSource = RetrofitBuilder()
        Log.i(TAG, "Tours request: Call is started")
        dataSource.getRetrofit().requestTours()
            .enqueue(object : Callback<TourData> {
                override fun onResponse(
                    call: Call<TourData>,
                    response: Response<TourData>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        Log.i(TAG, "onResponse: Response Successful")
                        tourDataFromRemoteData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<TourData>, t: Throwable) {
                    Log.i(TAG, "onFailure: " + t.message)
                }
            })

    }
}