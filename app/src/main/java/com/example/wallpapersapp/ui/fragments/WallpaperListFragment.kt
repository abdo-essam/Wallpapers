package com.example.wallpapersapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.wallpapersapp.databinding.FragmentWallpaperListBinding
import com.example.wallpapersapp.ui.fragments.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class WallpaperListFragment : Fragment() {

    private val fragments =
        listOf(HomeFragment(), PopularFragment(), CategoriesFragment())

    private val tabTitles = listOf("Home", "Popular", "Categories")

    private lateinit var binding: FragmentWallpaperListBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
        initTabLayout()
        initToolBar()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWallpaperListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun initViewPager() {
        val pagerAdapter = ViewPagerAdapter(context as FragmentActivity, fragments)
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.isUserInputEnabled = false
    }

    private fun initToolBar() {
        binding.toolbar.title = "Wallpapers"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }


}