package com.example.wallpapersapp.ui.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.example.wallpapersapp.model.Photo
import com.example.wallpapersapp.ui.fragments.WallpaperListFragmentDirections
import com.example.wallpapersapp.ui.recyclerView.RecyclerViewAdapter
import com.example.wallpapersapp.ui.recyclerView.WallpaperInteractionListener

abstract class BaseFragment<VB : ViewBinding>(
    private val layoutInflater: (inflater: LayoutInflater) -> VB
) : Fragment(), WallpaperInteractionListener {
    abstract var recyclerViewAdapter: RecyclerViewAdapter
    private var _binding: VB? = null
    val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = layoutInflater.invoke(inflater)
        if (_binding == null) {
            throw java.lang.IllegalArgumentException("Binding cannot be null")
        }
        initViewModel()
        initRecyclerView()
        return binding.root
    }

    abstract fun initViewModel()
    abstract fun initRecyclerView()

    override fun onClickItem(data: Photo, view: View) {
        Navigation.findNavController(view)
            .navigate(
                WallpaperListFragmentDirections.actionWallpaperListFragmentToDownloadFragment(
                    data.src.large
                )
            )

    }
}