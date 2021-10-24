package com.example.tamangfoodservicetest.presentation.view.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.presentation.adapter.BestRestaurantsAdapter
import com.example.tamangfoodservicetest.presentation.adapter.HomeRestaurantsAdapter
import com.example.tamangfoodservicetest.presentation.adapter.HomeViewPagerAdapter
import com.example.tamangfoodservicetest.presentation.adapter.PartnersAdapter
import com.example.tamangfoodservicetest.common.Constants
import com.example.tamangfoodservicetest.databinding.FragmentHomepageBinding
import com.example.tamangfoodservicetest.model.AllRestaurants
import com.example.tamangfoodservicetest.model.BestPartners
import com.example.tamangfoodservicetest.model.BestRestaurants
import com.example.tamangfoodservicetest.model.ImageList


class HomeFragment : Fragment(R.layout.fragment_homepage) {

    private lateinit var binding: FragmentHomepageBinding

    private var pagerAdapter = HomeViewPagerAdapter(
        listOf(
            ImageList(R.drawable.home_banner),
            ImageList(R.drawable.home_banner),
            ImageList(R.drawable.home_banner),
            ImageList(R.drawable.home_banner),
            ImageList(R.drawable.home_banner)
        )
    )

    private var partnersAdapter = PartnersAdapter(
        listOf(
            BestPartners(
                R.drawable.bg_partners, "Krispy Creme",
                "St Georgece Terrace, Perth"
            ),
            BestPartners(
                R.drawable.bg_partners, "Krispy Creme",
                "St Georgece Terrace, Perth"
            ),
            BestPartners(
                R.drawable.bg_partners, "Krispy Creme",
                "St Georgece Terrace, Perth"
            ),
            BestPartners(
                R.drawable.bg_partners, "Krispy Creme",
                "St Georgece Terrace, Perth"
            ),
            BestPartners(
                R.drawable.bg_partners, "Krispy Creme",
                "St Georgece Terrace, Perth"
            )
        )
    )

    private var bestRestaurantsAdapter = BestRestaurantsAdapter(
        listOf(
            BestRestaurants(
                R.drawable.bg_partners2, "McDonald’s",
                "Hay street , Perth City"
            ),
            BestRestaurants(
                R.drawable.bg_partners2, "McDonald’s",
                "Hay street , Perth City"
            ),
            BestRestaurants(
                R.drawable.bg_partners2, "McDonald’s",
                "Hay street , Perth City"
            ),
            BestRestaurants(
                R.drawable.bg_partners2, "McDonald’s",
                "Hay street , Perth City"
            ),
            BestRestaurants(
                R.drawable.bg_partners2, "McDonald’s",
                "Hay street , Perth City"
            ),
            BestRestaurants(
                R.drawable.bg_partners2, "McDonald’s",
                "Hay street , Perth City"
            ),
        )
    )


    private var allRestaurantsAdapter = HomeRestaurantsAdapter(
        listOf(
            AllRestaurants(R.drawable.bg_restaurants, "McDonald's"),
            AllRestaurants(R.drawable.bg_restaurants2, "Cafe Brichor’s"),
            AllRestaurants(R.drawable.bg_restaurants, "McDonald's"),
            AllRestaurants(R.drawable.bg_restaurants2, "Cafe Brichor’s"),
            AllRestaurants(R.drawable.bg_restaurants, "McDonald's"),
            AllRestaurants(R.drawable.bg_restaurants2, "Cafe Brichor’s"),
        )
    )

    private lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomepageBinding.bind(view)

        dotsIndicator()

        binding.vpSliderHomepage.adapter = pagerAdapter
        binding.vpSliderHomepage.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setDots(position)
            }
        })

        sharedPreferences = this.requireContext()
            .getSharedPreferences(Constants.Location.location, Context.MODE_PRIVATE)

        val location = sharedPreferences.getString("location", null)

        if (location != null) {
            binding.tvDeliveryTo.text = location
        } else {
            binding.tvDeliveryTo.text = R.string.location.toString()
        }

        initRecycler()

        binding.tvHomeFilter.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_home2_to_filterFragment2)
        }

        binding.tvSeeAll1.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_home2_to_featuredPartnersFragment2)
        }

        binding.tvSeeAll2.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_home2_to_topRestaurantFragment2)
        }

        binding.tvSeeAll3.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_home2_to_allRestaurantFragment2)
        }

    }

    private fun initRecycler() {
        binding.rvFeatures.adapter = partnersAdapter
        binding.rvFeatures.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)

        binding.rvBestPickRestaurants.adapter = bestRestaurantsAdapter
        binding.rvBestPickRestaurants.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)

        binding.rvRestaurant.adapter = allRestaurantsAdapter
        binding.rvRestaurant.isNestedScrollingEnabled = false
        binding.rvRestaurant.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
    }

    private fun dotsIndicator() {
        val mDots = arrayOfNulls<ImageView>(pagerAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)

        for (i in mDots.indices) {
            mDots[i] = ImageView(this.context)
            mDots[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator1_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            binding.lytViewPager1Dots.addView(mDots[i])
        }
    }

    fun setDots(index: Int) {
        val childCount = binding.lytViewPager1Dots.childCount
        for (i in 0 until childCount) {
            val imageView = binding.lytViewPager1Dots[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator1_active
                    )
                )
            } else imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.indicator1_inactive
                )
            )
        }
    }

}