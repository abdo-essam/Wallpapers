package com.example.wallpapersapp.ui.fragments

import com.example.wallpapersapp.databinding.FragmentRandomBinding
import com.example.wallpapersapp.ui.fragments.base.BaseFragment
import com.example.wallpapersapp.ui.recyclerView.RecyclerViewAdapter

class RandomFragment : BaseFragment<FragmentRandomBinding>(FragmentRandomBinding::inflate) {
    override var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter()

    override fun initViewModel() {
        TODO("Not yet implemented")
    }

    override fun initRecyclerView() {
        TODO("Not yet implemented")
    }


}