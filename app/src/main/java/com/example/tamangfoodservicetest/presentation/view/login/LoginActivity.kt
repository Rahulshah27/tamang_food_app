package com.example.tamangfoodservicetest.presentation.view.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.tamangfoodservicetest.LocationActivity
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.common.Constants
import com.example.tamangfoodservicetest.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref_signed_in = "Sign_IN"

        val sharedPreferences: SharedPreferences? =
            this.getSharedPreferences(Constants.SighIn.email, Context.MODE_PRIVATE)

        if(sharedPreferences?.getBoolean(pref_signed_in,false)!!){
            startActivity(Intent(this, LocationActivity::class.java))
            finish()
        }
        else {

            val navHost = supportFragmentManager.findFragmentById(R.id.loginFragmentContainer) as NavHostFragment
            navHost.findNavController().setGraph(R.navigation.nav_sign_in)
            navController = navHost.navController

            setSupportActionBar(binding.signInToolbar)
            setupActionBarWithNavController(navController)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()  || super.onSupportNavigateUp()
    }
}