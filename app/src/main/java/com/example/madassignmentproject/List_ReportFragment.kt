package com.example.madassignmentproject

import ReportAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import reportViewModel

class List_ReportFragment : Fragment() {

    private lateinit var reportAdapter: ReportAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("NavigationDebug", "Report List")

        // Initialize RecyclerView and Adapter
        val recyclerView = view.findViewById<RecyclerView>(R.id.reportRecyclerView)
        reportAdapter = ReportAdapter()
        recyclerView.adapter = reportAdapter

        // Assuming you have a reportViewModel to get the data
        val reportViewModel: reportViewModel = ViewModelProvider(this).get(reportViewModel::class.java)

        // Observe the list of reports and update the adapter when data changes
        reportViewModel.listReports().observe(viewLifecycleOwner, Observer { reports ->
            reports?.let { reportAdapter.setData(it) }
        })

        val Rbutton = view.findViewById<Button>(R.id.NewReport)
        Rbutton.setOnClickListener {
            view.findNavController().navigate(R.id.action_list_ReportFragment_to_add_ReportFragment)
        }
    }

}