package com.example.madassignmentproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("NavigationDebug", "MainActvity")

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.location_nav)
        val navController = navHostFragment?.findNavController()
        navController?.let { setupActionBarWithNavController(it) }

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Enable the Up button
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.location_nav)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}