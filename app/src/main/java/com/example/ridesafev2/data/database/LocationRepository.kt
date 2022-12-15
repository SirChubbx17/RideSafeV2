package com.example.ridesafev2.data.database

import androidx.lifecycle.LiveData

class LocationRepository(private val locationDao: LocationDao) {
    val readAllData: LiveData<List<Location>> = locationDao.readAllData()

    suspend fun addLocation(location: Location) {
        locationDao.addLocation(location)
    }

    suspend fun updateLocation(location: Location) {
        locationDao.updateLocation(location)
    }

    suspend fun deleteLocation(location: Location) {
        locationDao.deleteLocation(location)
    }

    suspend fun deleteAll() {
        locationDao.deleteAll()
    }
}