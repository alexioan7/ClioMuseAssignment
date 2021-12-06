package com.alexandros.cliomuseassignment.viewmodels

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexandros.cliomuseassignment.repositories.ToursRepository

class ViewModelFactory(private val repository: ToursRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(@NonNull modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ToursViewModel::class.java) -> {
                modelClass.cast(ToursViewModel(repository)) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}