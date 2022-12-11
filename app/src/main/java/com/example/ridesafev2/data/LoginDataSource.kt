package com.example.ridesafev2.data

import com.example.ridesafev2.data.model.LoggedInUser
import com.example.ridesafev2.data.user.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource (val database: UserDao){

    fun login(username: String, password: String): Result<LoggedInUser> {
        val usersNames = database.login(username)
        try {
            CoroutineScope(Dispatchers.IO).launch {
                if(usersNames.password == password) {
                    val User = LoggedInUser(usersNames.userId.toString(),usersNames.name)
                    Result.Success(User)
                }
            }
            return Result.Error(IOException("Wrong password"))
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

