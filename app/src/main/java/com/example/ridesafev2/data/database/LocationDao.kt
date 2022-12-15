package com.example.ridesafev2.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLocation(location: Location)

    @Update
    suspend fun updateLocation(location: Location)

    @Delete
    suspend fun deleteLocation(location: Location)

    @Query("DELETE FROM location_table")
    suspend fun deleteAllLocation()

    @Query("SELECT * FROM location_table ORDER BY id asc")
    fun readAllData(): LiveData<List<Location>>

}