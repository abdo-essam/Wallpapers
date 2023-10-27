package com.example.wallpapersapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.wallpapersapp.R
import com.example.wallpapersapp.databinding.FragmentDownloadBinding


class DownloadFragment : Fragment() {
    private lateinit var binding: FragmentDownloadBinding
    private val  args: DownloadFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDownloadBinding.inflate(inflater)
        loadImage(args.image)
        bottomSheet()
        addCallBack()
        return binding.root
    }

    private fun loadImage(url: String) {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .error(R.drawable.baseline_error_24)
            .into(binding.imgDownload)
    }

    private fun addCallBack() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun bottomSheet() {
        val bottomSheetFragment = BottomSheetFragment(args.image)
        binding.fabDownload.setOnClickListener {
            bottomSheetFragment.show(requireActivity().supportFragmentManager, "bottomSheetDialog")
        }
    }


}