package com.example.ridesafev2.fragment.add

import android.icu.number.IntegerWidth
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ridesafev2.R
import com.example.ridesafev2.data.database.Location
import com.example.ridesafev2.data.viewModel.LocationViewModel
import com.example.ridesafev2.databinding.RsFragAdventureBinding
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Adventure : Fragment() {

    private var _binding: RsFragAdventureBinding? = null

    private lateinit var mLocationViewModel: LocationViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = RsFragAdventureBinding.inflate(inflater, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Add Data"
        mLocationViewModel = ViewModelProvider(this).get(LocationViewModel::class.java)

        binding.btnGo.setOnClickListener {
            insertDataToDatabase()
            findNavController().navigate(R.id.action_adventure_to_mapsActivity2)
        }
        binding.btnDetails.setOnClickListener {
            findNavController().navigate(R.id.action_adventure_to_history)
        }


        return binding.root

    }

    private fun insertDataToDatabase() {
        val Current_location = binding.currentLoc.text
        val Destination = binding.destination1.text

        if(inputCheck(Current_location, Destination)) {
            // Create User Object
            val location = Location(0, Integer.parseInt(Current_location.toString()), Integer.parseInt(Destination.toString())) // <- Pass id, firstName, lastName, and age. Although id will be auto-generated because it is a primary key, we need to pass a value or zero (Don't worry, the Room library knows it is the primary key and is auto-generated).

            // Add Data to database
            mLocationViewModel.addLocation(location)
            Snackbar.make(requireView(), "Successfully Added!", Snackbar.LENGTH_SHORT).show()
            // Navigate back
            findNavController().navigate(R.id.action_adventure_to_mapsActivity2)
        } else {
            Snackbar.make(requireView(), "Please fill out all fields!", Snackbar.LENGTH_LONG).show()
        }


    }

    private fun inputCheck(Current_location: Editable?, Destination: Editable?): Boolean {
        return !(TextUtils.isEmpty(Current_location) && TextUtils.isEmpty(Destination))

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
