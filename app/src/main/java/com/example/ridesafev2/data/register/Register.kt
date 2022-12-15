package com.example.ridesafev2.data.register

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ridesafev2.R
import com.example.ridesafev2.data.user.UserDatabase
import com.example.ridesafev2.databinding.RsFragRegisterBinding
import com.example.ridesafev2.ui.login.LoginActivity

class Register : Fragment() {
    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<RsFragRegisterBinding>(
            inflater,
            R.layout.rs_frag_register,
            container,
            false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = UserDatabase.getInstance(application).userDao

        val viewModelFactory = RegisterViewModelFactory(dataSource, application)

        val registerViewModel =
            ViewModelProvider(
                this, viewModelFactory
            )[RegisterViewModel::class.java]

//        registerViewModel.navigateToLogin.observe(this, Observer {
//            this.findNavController().navigate(
//                //R.id.action_registerFragment_to_loginFragment
//            )
//            registerViewModel.doneNavigating()
//        })

        binding.registerViewModel = registerViewModel

        binding.setLifecycleOwner(this)


        return binding.root
    }
}