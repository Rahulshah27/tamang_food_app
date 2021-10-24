package com.example.tamangfoodservicetest.presentation.view.login

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.common.Constants
import com.example.tamangfoodservicetest.databinding.FragmentProvideMobileNoBinding
import com.example.tamangfoodservicetest.util.showToast


class ProvideMobileNoFragment : Fragment(R.layout.fragment_provide_mobile_no) {


    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentProvideMobileNoBinding.bind(view)

        binding.ccp.setDefaultCountryUsingNameCode("IND")

        binding.btnMobileSignUp.setOnClickListener {

            if(binding.etPhoneNumber.text.isNullOrEmpty()){
                this.context?.showToast("Provide Phone number")
            } else
                if (binding.etPhoneNumber.text!!.length!=10){
                    this.context?.showToast("Phone number invalid")
                }

            else {
                val bundle = Bundle()
                bundle.putString(
                    Constants.Bundles.phone,
                    "+${binding.ccp.selectedCountryCode} ${binding.etPhoneNumber.text}"
                )

                val navController: NavController = Navigation.findNavController(view)
                navController.navigate(
                    R.id.action_provideMobileNoFragment2_to_verifyMobileNoFragment2,
                    bundle
                )
            }
        }
    }
}