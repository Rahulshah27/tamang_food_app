package com.example.tamangfoodservicetest.presentation.view.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.tamangfoodservicetest.R
import com.example.tamangfoodservicetest.presentation.adapter.FeaturedItemsAdapter
import com.example.tamangfoodservicetest.presentation.adapter.HomeViewPagerAdapter
import com.example.tamangfoodservicetest.common.Constants
import com.example.tamangfoodservicetest.databinding.FragmentSingleRestaurantBinding
import com.example.tamangfoodservicetest.model.ImageList
import com.example.tamangfoodservicetest.model.Partners

import kotlin.math.abs


class SingleRestaurantFragment : Fragment() {

    private lateinit var binding : FragmentSingleRestaurantBinding

    private lateinit var pagerAdapter: HomeViewPagerAdapter
    private lateinit var sliderHandler: Handler
    private lateinit var sliderRunnable: Runnable
    private lateinit var sharedPreferences: SharedPreferences

    private var itemAdapter = FeaturedItemsAdapter(
        listOf(
            Partners(R.drawable.header_image, "Cookie Sandwich"),
            Partners(R.drawable.header_image, "Chow Fun"),
            Partners(R.drawable.header_image, "Dim SUm"),
            Partners(R.drawable.header_image, "Cookie Sandwich"),
            Partners(R.drawable.header_image, "Chow Fun"),
            Partners(R.drawable.header_image, "Dim SUm")
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_single_restaurant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSingleRestaurantBinding.bind(view)

        sharedPreferences =
            this.requireContext().getSharedPreferences(Constants.Prefs.image, Context.MODE_PRIVATE)

        val title = sharedPreferences.getString("title",null)
        val image = sharedPreferences.getInt("image",R.drawable.header_image)

        pagerAdapter = HomeViewPagerAdapter(
            listOf(
                ImageList(image),
                ImageList(image),
                ImageList(image),
                ImageList(image),
                ImageList(image)
            )
        )

        binding.tvSingleRestaurantName.text = title

        binding.rvSingleRestaurant.adapter = itemAdapter
        binding.rvSingleRestaurant.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)

        val bundle = Bundle()
        bundle.putInt(Constants.Prefs.image, image)
        bundle.putString(Constants.Prefs.title, title)

        binding.btnTakeAway.setOnClickListener {
            val singleNavController: NavController = Navigation.findNavController(view)
            singleNavController.navigate(
                R.id.action_singleRestaurantFragment2_to_addToOrderFragment2,
                bundle
            )
        }

        binding.imageBack.setOnClickListener {
            activity?.onBackPressed()
        }

        binding.imageShare.setOnClickListener {

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, title)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)        }

        binding.viewPagerSingle.adapter = pagerAdapter

        val pageTurn = CompositePageTransformer()
        pageTurn.addTransformer(MarginPageTransformer(40))
        pageTurn.addTransformer { page, position ->
            val r: Float = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }

        binding.viewPagerSingle.setPageTransformer(pageTurn)
        sliderHandler = Handler()
        sliderRunnable = Runnable {

            if (binding.viewPagerSingle.currentItem == pagerAdapter.itemCount) {
                binding.viewPagerSingle.currentItem = 0
            } else {
                binding.viewPagerSingle.currentItem = binding.viewPagerSingle.currentItem + 1
            }
        }

        dotsIndicator()

        binding.viewPagerSingle.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            private var currentPage: Int = 0

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setDots(position)
                currentPage = position
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 2000)

            }

            override fun onPageScrollStateChanged(state: Int) {
                if (state == 1 && currentPage == pagerAdapter.itemCount - 1) {
                    currentPage = 0
                    binding.viewPagerSingle.currentItem = currentPage
                }

            }
        })

        val tabAdapter = TabAdapter(requireActivity().supportFragmentManager, lifecycle)
        binding.viewPagerTab.adapter = tabAdapter

        TabLayoutMediator(binding.tabLayoutTab, binding.viewPagerTab) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Beef & Lamb"
                }
                1 -> {
                    tab.text = "Seafood"
                }
                2 -> {
                    tab.text = "Appetizers"
                }
                else -> tab.text = "Dim Sum"
            }
        }.attach()


        binding.viewPagerTab.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            private var currentPage: Int = 0
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                currentPage = position
            }


            override fun onPageScrollStateChanged(state: Int) {
                if (state == 1 && currentPage == 4) {

                    currentPage = 0

                    binding.viewPagerTab.currentItem = currentPage

                }

            }
        })

    }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 2000)
    }

    inner class TabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {
        private val totalTabs = 4

        override fun getItemCount(): Int {
            return totalTabs
        }

        override fun createFragment(position: Int): Fragment {
            return SingleRestaurantTabFragment()
        }
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
            binding.lytViewPagerSingle.addView(mDots[i])
        }
    }

    fun setDots(index: Int) {
        val childCount = binding.lytViewPagerSingle.childCount
        for (i in 0 until childCount) {
            val imageView = binding.lytViewPagerSingle[i] as ImageView
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
