package com.example.tamangfoodservicetest.presentation.view.yourorders

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.databinding.FragmentPaymentBinding
import com.example.tamangfoodservicetest.util.showToast

class PaymentFragment : Fragment(R.layout.fragment_payment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPaymentBinding.bind(view)

        binding.btnAddCard.setOnClickListener {
            this.context?.showToast("Card Added Successfully!")
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_paymentFragment2_to_bottomNavigationActivity)
            requireActivity().finish()
        }

        binding.btnScanCard.setOnClickListener {
            val cameraIntent = Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
            startActivity(cameraIntent)
        }
    }
}