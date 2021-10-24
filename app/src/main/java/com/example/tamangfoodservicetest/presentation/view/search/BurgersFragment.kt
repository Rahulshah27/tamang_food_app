package com.example.tamangfoodservicetest.presentation.view.search
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.presentation.adapter.FeaturedPartnerAdapter
import com.example.tamangfoodservicetest.common.Constants
import com.example.tamangfoodservicetest.databinding.FragmentBurgersBinding
import com.example.tamangfoodservicetest.model.Partners

class BurgersFragment : Fragment(R.layout.fragment_burgers) {

    private var partnerAdapter = FeaturedPartnerAdapter(
        listOf(
            Partners(R.drawable.bg_burgers, "McDonald's"),
            Partners(R.drawable.bg_burgers2, "Tacos Nanchas"),
            Partners(R.drawable.bg_burgers, "McDonald's"),
            Partners(R.drawable.bg_burgers2, "Tacos Nanchas"),
            Partners(R.drawable.bg_burgers, "McDonald's"),
            Partners(R.drawable.bg_burgers2, "Tacos Nanchas"),
            Partners(R.drawable.bg_burgers, "McDonald's"),
            Partners(R.drawable.bg_burgers2, "Tacos Nanchas"),
            Partners(R.drawable.bg_burgers, "McDonald's"),
            Partners(R.drawable.bg_burgers2, "Tacos Nanchas"),
            Partners(R.drawable.bg_burgers, "McDonald's"),
            Partners(R.drawable.bg_burgers2, "Tacos Nanchas"),
            Partners(R.drawable.bg_burgers, "McDonald's"),
            Partners(R.drawable.bg_burgers2, "Tacos Nanchas"),
            Partners(R.drawable.bg_burgers, "McDonald's"),
            Partners(R.drawable.bg_burgers2, "Tacos Nanchas")
        )
    )

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBurgersBinding.bind(view)

        val args = this.arguments
        val title = args?.getString(Constants.Prefs.title)

        if (title == null){
            binding.tvCount.text = "We have founds ${partnerAdapter.itemCount} results for your search"
            //bottomToolbar.title = "Search Results"
        } else {
            binding.tvCount.text = "We have founds ${partnerAdapter.itemCount} results for $title"
            //bottomToolbar.title = title
        }

        binding.rvBurgers.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        )

        binding.rvBurgers.adapter = partnerAdapter

        binding.tvSearchAgain.setOnClickListener {
            activity?.onBackPressed()
        }

    }
}