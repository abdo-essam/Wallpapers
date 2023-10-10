package com.example.wallpapersapp.ui.fragments


import com.example.wallpapersapp.databinding.FragmentPopularBinding
import com.example.wallpapersapp.ui.fragments.base.BaseFragment
import com.example.wallpapersapp.ui.recyclerView.RecyclerViewAdapter

class PopularFragment : BaseFragment<FragmentPopularBinding>(FragmentPopularBinding::inflate) {
    override var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter()
    override fun initViewModel() {
        TODO("Not yet implemented")
    }

    override fun initRecyclerView() {
        TODO("Not yet implemented")
    }


}