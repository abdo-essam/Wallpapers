package com.example.wallpapersapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpapersapp.databinding.FragmentCategoriesBinding
import com.example.wallpapersapp.model.Category
import com.example.wallpapersapp.ui.recyclerView.CategoryAdapter
import com.example.wallpapersapp.ui.recyclerView.CategoryInteractionListener
import com.example.wallpapersapp.utils.ApiCategories


class CategoriesFragment : Fragment(), CategoryInteractionListener {

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
        recyclerViewAdapter = CategoryAdapter(ApiCategories.categoriesList, this)
        binding.rvCategories.layoutManager = layoutManager
        binding.rvCategories.adapter = recyclerViewAdapter
    }

    override fun onClickCategory(category: Category, view: View) {
        Navigation.findNavController(view).navigate(
            WallpaperListFragmentDirections.actionWallpaperListFragmentToSpecificCategoryFragment(
                category.categoryName
            )
        )
    }

}