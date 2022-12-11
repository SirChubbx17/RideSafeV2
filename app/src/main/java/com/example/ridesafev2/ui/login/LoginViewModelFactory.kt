package com.example.ridesafev2.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ridesafev2.data.LoginDataSource
import com.example.ridesafev2.data.LoginRepository
import com.example.ridesafev2.data.user.UserDao

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory(private val dataSource: UserDao) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    dataSource = LoginDataSource(dataSource)
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}