package com.example.ridesafev2.data.database


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "location_table") // User Entity represents a table within the database.
data class Location(
    @PrimaryKey(autoGenerate = true)
    val id: Int, // <- 'id' is the primary key which will be autogenerated by the Room library.
    val start_location: String,
    val end_location: String,
    val close_encounters: Int,
    val adventureTime: Int
):Parcelable