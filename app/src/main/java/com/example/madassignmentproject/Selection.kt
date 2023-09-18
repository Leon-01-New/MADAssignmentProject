package com.example.madassignmentproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class Selection : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        Log.d("NavigationDebug", "Selection")

        val view = inflater.inflate(R.layout.fragment_selection, container, false)

        val rbutton = view.findViewById<Button>(R.id.Report)

        val rpbutton = view.findViewById<Button>(R.id.Recycle_Point)

        rbutton.setOnClickListener {
            view.findNavController().navigate(R.id.action_selection_to_list_ReportFragment)
        }

        rpbutton.setOnClickListener{
            view.findNavController().navigate(R.id.action_selection_to_add_Recycle_PointFragment)
        }

        return view
    }

}