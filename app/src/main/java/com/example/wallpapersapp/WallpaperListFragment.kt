package com.example.wallpapersapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wallpapersapp.databinding.FragmentWallpaperListBinding


class WallpaperListFragment : Fragment() {


    private lateinit var binding: FragmentWallpaperListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWallpaperListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

}