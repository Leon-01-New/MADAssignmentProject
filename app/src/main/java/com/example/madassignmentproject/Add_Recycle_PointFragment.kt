package com.example.madassignmentproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.greenwizard.data.recyclepoint
import reportViewModel

class Add_Recycle_PointFragment : Fragment() {

    private val reportViewModel: reportViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("NavigationDebug", "Add new recycle")

        val view = inflater.inflate(R.layout.fragment_add_recycle_point, container, false)

        val addBtn = view.findViewById<Button>(R.id.SubmitButton)
        val addLocation = view.findViewById<EditText>(R.id.LocationInput)
        val addRecyclePointName = view.findViewById<EditText>(R.id.RecyclePointNameInput)

        addBtn.setOnClickListener {
            val location = addLocation.text.toString()
            val recyclePointName = addRecyclePointName.text.toString()

            // Create news Object
            val recyclePoint = recyclepoint(0, recyclePointName,location) // Assuming 'id' is an auto-generated primary key

            // Add data to ViewModel
            reportViewModel.addRecycle(recyclePoint)

            Toast.makeText(requireContext(), "Data added successfully", Toast.LENGTH_SHORT).show()

            // Navigate Back
//                findNavController().navigate(R.id.action_add_ReportFragment_to_selection)

        }

        return view
    }
}