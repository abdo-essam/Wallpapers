package com.example.wallpapersapp.ui.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpapersapp.databinding.FragmentHomeBinding
import com.example.wallpapersapp.ui.fragments.base.BaseFragment
import com.example.wallpapersapp.ui.recyclerView.RecyclerViewAdapter
import com.example.wallpapersapp.ui.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate)
{
    override var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter()
    private val viewModel: HomeViewModel by viewModels()
    override fun initViewModel() {
        lifecycleScope.launch {
            viewModel.homePage.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    override fun initRecyclerView() {
        val layoutManager = GridLayoutManager(context, 2)
        binding.rvHomeFragment.layoutManager = layoutManager
        binding.rvHomeFragment.adapter = recyclerViewAdapter
    }


}