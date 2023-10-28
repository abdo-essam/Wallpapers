package com.example.wallpapersapp.ui.fragments


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpapersapp.databinding.FragmentPopularBinding
import com.example.wallpapersapp.ui.fragments.base.BaseFragment
import com.example.wallpapersapp.ui.recyclerView.RecyclerViewAdapter
import com.example.wallpapersapp.ui.recyclerView.WallpaperInteractionListener
import com.example.wallpapersapp.viewmodel.PopularViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PopularFragment : BaseFragment<FragmentPopularBinding>(FragmentPopularBinding::inflate),
    WallpaperInteractionListener {
    private val viewModel: PopularViewModel by viewModels()
    override var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter(this)

    override fun initViewModel() {
        lifecycleScope.launch {
            viewModel.popularPage.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }
    override fun initRecyclerView() {
        val layoutManager = GridLayoutManager(context,3)
        binding.recyclerviewPopular.layoutManager=layoutManager
        binding.recyclerviewPopular.adapter=recyclerViewAdapter
    }
}