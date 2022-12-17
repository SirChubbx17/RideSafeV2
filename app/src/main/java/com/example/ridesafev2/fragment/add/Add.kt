package com.example.ridesafev2.fragment.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ridesafev2.R
import com.example.ridesafev2.data.database.Location
import com.example.ridesafev2.data.database.LocationViewModel
import com.example.ridesafev2.databinding.RsFragAdventureBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Add : Fragment() {

    private var _binding: RsFragAdventureBinding? = null

    private lateinit var locationViewModel: LocationViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = RsFragAdventureBinding.inflate(inflater, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Add Data"
        locationViewModel = ViewModelProvider(this).get(LocationViewModel::class.java)

        binding.btnGo.setOnClickListener {
            insertDataToDatabase()
        }
        binding.btnDetails.setOnClickListener {
            findNavController().navigate(R.id.action_adventure_to_history)
        }


        return binding.root

    }

    private fun insertDataToDatabase() {
        val currentloc = binding.currentLoc.text
        val destination = binding.destination.text
        val closeenc = binding.closeEncounters.text
        val adventuretime = binding.timetaken.text

        if(inputCheck(currentloc, destination, closeenc, adventuretime)) {
            // Create User Object
            val location = Location(0, currentloc.toString(),destination.toString(),Integer.parseInt(closeenc.toString()),Integer.parseInt(adventuretime.toString())) // <- Pass id, firstName, lastName, and age. Although id will be auto-generated because it is a primary key, we need to pass a value or zero (Don't worry, the Room library knows it is the primary key and is auto-generated).

            // Add Data to database
            locationViewModel.addLocation(location)
            Toast.makeText(context,"Success!",Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(context,"Please fill out all fields.",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(currentloc: Editable?, destination: Editable?, closeenc: Editable?, adventuretime: Editable?): Boolean {
        return !(TextUtils.isEmpty(currentloc) && TextUtils.isEmpty(destination) && TextUtils.isEmpty(closeenc) && TextUtils.isEmpty(adventuretime))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
