package com.example.ridesafev2.data.repo

import androidx.lifecycle.LiveData
import com.example.ridesafev2.data.database.Location
import com.example.ridesafev2.data.database.LocationDao


class LocationRepository(private val locationDao: LocationDao) {
    val readAllData: LiveData<List<Location>> = locationDao.readAllData()

    suspend fun addStorage(location: Location) {
        locationDao.addLocation(location)
    }

    suspend fun updateStorage(location: Location) {
        locationDao.updateLocation(location)
    }

    suspend fun deleteStorage(location: Location) {
        locationDao.deleteLocation(location)
    }

    suspend fun deleteAllStorages() {
        locationDao.deleteAllLocation()
    }
}