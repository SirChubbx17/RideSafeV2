package com.example.ridesafev2.data.repo

import androidx.lifecycle.LiveData
import com.example.ridesafev2.data.database.Location
import com.example.ridesafev2.data.database.LocationDao


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

    suspend fun deleteAllLocation() {
        locationDao.deleteAllLocation()
    }
}