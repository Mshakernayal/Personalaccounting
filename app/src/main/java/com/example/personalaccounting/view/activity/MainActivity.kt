package com.example.personalaccounting.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.personalaccounting.R
import com.example.personalaccounting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return  navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun insert()
    {
        val name = "alsdf"
    }
}