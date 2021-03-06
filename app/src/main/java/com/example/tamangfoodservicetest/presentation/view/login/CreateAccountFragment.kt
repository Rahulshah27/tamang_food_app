package com.example.tamangfoodservicetest.presentation.view.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.common.Constants
import com.example.tamangfoodservicetest.databinding.FragmentCreateAccountBinding
import com.example.tamangfoodservicetest.util.showToast


class CreateAccountFragment : Fragment(R.layout.fragment_create_account) {


    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCreateAccountBinding.bind(view)

        val sharedPreferences: SharedPreferences? =
            context?.getSharedPreferences(Constants.SighIn.email, Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor? = sharedPreferences?.edit()

        binding.btnSignUp.setOnClickListener {

            val name = binding.etCreateName.text.toString()
            val email = binding.etCreateEmailID.text.toString()
            val password = binding.etCreatePW.text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {

                Toast.makeText(context, "Please Fill All the Fields", Toast.LENGTH_SHORT).show()
            } else

                if (!sharedPreferences?.getString("Email$email", "").isNullOrEmpty()
                ) {
                    Toast.makeText(context, "Email is already Registered", Toast.LENGTH_SHORT)
                        .show(); } else

                    if (!email.matches(emailPattern.toRegex())) {

                        this.context?.showToast("Invalid email address")

                    } else {

                        editor?.putString("Name$name", name)?.apply()
                        editor?.putString("Password$password", password)?.apply()
                        editor?.putString("Email$email", email)?.apply()

                        val navController: NavController = Navigation.findNavController(view)
                        navController.navigate(R.id.action_createAccountFragment2_to_provideMobileNoFragment2)
                    }
        }

        binding.tvHaveAccount.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_createAccountFragment2_to_signInFragment2)
        }
    }
}


