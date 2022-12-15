package com.example.ridesafev2.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ridesafev2.data.database.Location
import com.example.ridesafev2.data.database.LocationDatabase
import com.example.ridesafev2.data.repo.LocationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationViewModel (application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Location>>
    private val repository: LocationRepository

    init {
        val locationDao = LocationDatabase.getDatabase(application).locationDao()
        repository= LocationRepository(locationDao)
        readAllData = repository.readAllData
    }

    fun addStorage(storage: Location) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addStorage(storage)
        }
    }

    fun updateStorage(storage: Location) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateStorage(storage)
        }
    }

    fun deleteStorage(storage: Location) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteStorage(storage)
        }
    }

    fun deleteAllStorages() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllStorages()
        }
    }
}
