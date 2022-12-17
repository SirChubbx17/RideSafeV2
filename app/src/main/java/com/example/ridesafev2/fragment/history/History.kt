package com.example.ridesafev2.fragment.history

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.ridesafev2.R
import com.example.ridesafev2.data.database.Location
import com.example.ridesafev2.data.database.LocationDatabase
import com.example.ridesafev2.data.database.LocationViewModel
import com.example.ridesafev2.databinding.RsFragHistoryBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class History : Fragment(){

    private var _binding: RsFragHistoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var userViewModel: LocationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = RsFragHistoryBinding.inflate(inflater, container, false)
        // val view = inflater.inflate(R.layout.fragment_list, container, false) // <- This is not required.
        (activity as AppCompatActivity).supportActionBar?.title = "History"
        // RecyclerView
        val adapter = HistoryAdapter()
        // val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview) // <- This is replaced.
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        userViewModel = ViewModelProvider(this).get(LocationViewModel::class.java)
        userViewModel.readAllData.observe(viewLifecycleOwner, Observer { location ->
            adapter.setData(location)
        })

        // Add menu
        setHasOptionsMenu(true)

        return binding.root
    }

//
//    // Implement logic to delete all users
//    private fun deleteAllUsers() {
//        val builder = AlertDialog.Builder(requireContext())
//        builder.setPositiveButton("Yes") { _, _ ->     // Make a "Yes" option and set action if the user selects "Yes"
//            userViewModel.deleteAll()    // Execute : delete all users
//            // Notification if a user is deleted successfully
//            Snackbar.make(requireView(), "Successfully Removed Everything", Snackbar.LENGTH_LONG).show()
//            // Note: No need to navigate app user to List Fragment since deleting all users takes place at List Fragment.
//        }
//        builder.setNegativeButton("No") { _, _ -> }    // Make a "No" option and set action if the user selects "No"
//        builder.setTitle("Delete everything?")  // Set the title of the prompt with a sentence saying the first name of the user inside the app (using template string)
//        builder.setMessage("Are you sure you want to remove everything?")  // Set the message of the prompt with a sentence saying the first name of the user inside the app (using template string)
//        builder.create().show()  // Create a prompt with the configuration above to ask the user (the real app user which is human)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // <- whenever we destroy our fragment, _binding is set to null. Hence it will avoid memory leaks.
    }

}


