package com.example.tamangfoodservicetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tamangfoodservicetest.databinding.ActivityBottomNavigationBinding

class BottomNavigationActivity: AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.navHostBottomNav) as NavHostFragment
        binding.btmNavView.setupWithNavController(navHost.findNavController())
        navController = navHost.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()  || super.onSupportNavigateUp()
    }

}