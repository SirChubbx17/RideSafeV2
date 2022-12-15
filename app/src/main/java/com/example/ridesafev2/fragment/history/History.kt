package com.example.ridesafev2.fragment.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ridesafev2.data.viewModel.LocationViewModel
import com.example.ridesafev2.databinding.RsFragHistoryBinding

class History : Fragment(){
    private var _binding: RsFragHistoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var mUserViewModel: LocationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RsFragHistoryBinding.inflate(inflater, container, false)
        val adapter = HistoryAdapter()

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(LocationViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { location ->
            adapter.setData(location)
        })
        return binding.root

    }

}


