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
import com.example.greenwizard.data.dumpreports
import reportViewModel


class Add_ReportFragment : Fragment() {

    private val reportViewModel: reportViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("NavigationDebug", "Add new report")

        val view = inflater.inflate(R.layout.fragment_add_report, container, false)

        val addBtn = view.findViewById<Button>(R.id.SubmitButton)
        val addLocation = view.findViewById<EditText>(R.id.LocationInput)
        val addReportDateTime = view.findViewById<EditText>(R.id.ReportedDateTimeInput)
        val addTypeOfWaste = view.findViewById<EditText>(R.id.TypeOfWasteInput)

        addBtn.setOnClickListener {
            val location = addLocation.text.toString()
            val reporteDateTime = addReportDateTime.text.toString()
            val typeOfWaste = addTypeOfWaste.text.toString()
            val status = "new"
                // Create news Object
                val illegalDumpReport = dumpreports(0, location,reporteDateTime,typeOfWaste,status ) // Assuming 'id' is an auto-generated primary key
                // Add data to ViewModel
                reportViewModel.addReport(illegalDumpReport)

            Toast.makeText(requireContext(), "Data added successfully", Toast.LENGTH_SHORT).show()

            // Navigate Back
//                findNavController().navigate(R.id.action_add_ReportFragment_to_selection)

            }

        return view
    }

}