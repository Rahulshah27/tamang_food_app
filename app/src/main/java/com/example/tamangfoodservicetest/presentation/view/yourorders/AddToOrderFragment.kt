package com.example.tamangfoodservicetest.presentation.view.yourorders

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.common.Constants
import com.example.tamangfoodservicetest.databinding.FragmentAddToOrderBinding
import com.example.tamangfoodservicetest.util.showToast

class AddToOrderFragment : Fragment(R.layout.fragment_add_to_order) {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAddToOrderBinding.bind(view)

        val args = this.arguments
        val title = args?.getString(Constants.Prefs.title)
        val image = args?.getInt(Constants.Prefs.image)

        binding.imageAddToOrder.setImageResource(image!!)
        binding.tvAddToOrderName.text = title

//        binding.btnAddToOrder.setOnClickListener {
//            val singleNavController: NavController = Navigation.findNavController(view)
//            singleNavController.navigate(R.id.action_addToOrderFragment2_to_yourOrdersActivity)
//        }

        binding.btnAddSpecialInstructions.setOnClickListener {
            this.context?.showToast("Currently this option is not available")
        }

        var count = 0
        if (count < 10) {
            binding.tvAddToOrderCount.text = "0$count"
        } else {
            binding.tvAddToOrderCount.text = "$count"
        }
        binding.btnAddtoOrderPlus.setOnClickListener {
            count += 1
            if (count < 10) {
                binding.tvAddToOrderCount.text = "0$count"
            } else {
                binding.tvAddToOrderCount.text = "$count"
            }
        }

        binding.btnAddToOrderMinus.setOnClickListener {
            count -= 1
            if (count > 0) {
                if (count < 10) {
                    binding.tvAddToOrderCount.text = "0$count"
                } else {
                    binding.tvAddToOrderCount.text = "$count"
                }
            } else {
                count = 0
                if (count < 10) {
                    binding.tvAddToOrderCount.text = "0$count"
                } else {
                    binding.tvAddToOrderCount.text = "$count"
                }
            }
        }

    }


}