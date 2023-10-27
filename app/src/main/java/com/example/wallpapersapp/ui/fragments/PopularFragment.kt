package com.example.wallpapersapp.ui.fragments


import android.view.View
import com.example.wallpapersapp.databinding.FragmentPopularBinding
import com.example.wallpapersapp.model.Photo
import com.example.wallpapersapp.ui.fragments.base.BaseFragment
import com.example.wallpapersapp.ui.recyclerView.RecyclerViewAdapter
import com.example.wallpapersapp.ui.recyclerView.WallpaperInteractionListener

class PopularFragment : BaseFragment<FragmentPopularBinding>(FragmentPopularBinding::inflate),
    WallpaperInteractionListener {
    override var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter(this)
    override fun initViewModel() {
        TODO("Not yet implemented")
    }

    override fun initRecyclerView() {
        TODO("Not yet implemented")
    }

    override fun onClickItem(data: Photo, view: View) {
        TODO("Not yet implemented")
    }


}