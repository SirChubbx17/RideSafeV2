package com.example.ridesafev2.fragment.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ridesafev2.R
import com.example.ridesafev2.data.database.Location
import com.example.ridesafev2.data.database.LocationViewModel
import com.example.ridesafev2.databinding.RsFragAdventureBinding
import com.example.ridesafev2.databinding.RsFragUpdateBinding

class Update : Fragment() {

    private val args by navArgs<UpdateArgs>()

    private lateinit var locationViewModel: LocationViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private var _binding: RsFragUpdateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = RsFragUpdateBinding.inflate(inflater, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Update Data"

        locationViewModel = ViewModelProvider(this).get(LocationViewModel::class.java)

        binding.updateCurrentLoc.setText(args.currentAdventure.start_location)
        binding.updateDestination.setText(args.currentAdventure.end_location)
        binding.updateCloseEncounters.setText(args.currentAdventure.close_encounters.toString())
        binding.updateTimetaken.setText(args.currentAdventure.adventureTime.toString())

        binding.btnUpdate.setOnClickListener {
            updateItem()
        }

        // Add menu
        setHasOptionsMenu(true)

        return view
    }


    private fun updateItem() {
        val currentloc = binding.updateCurrentLoc.text
        val destination = binding.updateDestination.text
        val closeenc = binding.updateCloseEncounters.text
        val adventuretime = binding.updateTimetaken.text

        if (inputCheck(currentloc, destination, closeenc, adventuretime)) {
            // Create User Object
            val location = Location(0, currentloc.toString(),destination.toString(),Integer.parseInt(closeenc.toString()),Integer.parseInt(adventuretime.toString()))
            // Update Current User
            locationViewModel.addLocation(location)
            Toast.makeText(context,"Success!",Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_update_to_history)
        } else {
            Toast.makeText(context,"Please fill out all fields.",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(currentloc: Editable?, destination: Editable?, closeenc: Editable?, adventuretime: Editable?): Boolean {
        return !(TextUtils.isEmpty(currentloc) && TextUtils.isEmpty(destination) && TextUtils.isEmpty(closeenc) && TextUtils.isEmpty(adventuretime))
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.delete_menu, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.menu_delete) {
//            deleteUser()
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//    private fun deleteAdventure() {
//        val builder = AlertDialog.Builder(requireContext())
//        builder.setPositiveButton("Yes") { _, _ ->
//            locationViewModel.deleteUser(args.currentUser)
//            Toast.makeText(
//                requireContext(),
//                "Successfully removed: ${args.currentUser.firstName}",
//                Toast.LENGTH_SHORT).show()
//            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
//        }
//        builder.setNegativeButton("No") { _, _ -> }
//        builder.setTitle("Delete ${args.currentUser.firstName}?")
//        builder.setMessage("Are you sure you want to delete ${args.currentUser.firstName}?")
//        builder.create().show()
//    }

}