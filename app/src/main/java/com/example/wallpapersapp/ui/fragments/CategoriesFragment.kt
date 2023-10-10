package com.example.wallpapersapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpapersapp.databinding.FragmentCategoriesBinding
import com.example.wallpapersapp.ui.recyclerView.CategoryAdapter
import com.example.wallpapersapp.utils.ApiCategories


class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var recyclerViewAdapter: CategoryAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        initRecyclerViewAdapter()
        return binding.root
    }

    private fun initRecyclerViewAdapter() {
        val layoutManager = GridLayoutManager(context, 2)
        recyclerViewAdapter = CategoryAdapter(ApiCategories.categoriesList)
        binding.rvCategories.layoutManager = layoutManager
        binding.rvCategories.adapter = recyclerViewAdapter
    }

}