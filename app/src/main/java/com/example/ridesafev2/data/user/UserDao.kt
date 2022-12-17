package com.example.ridesafev2.data.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert
    fun register(user: User)


    @Query("SELECT * FROM user_table WHERE username LIKE :username")
    fun login(username: String): User

}