package com.example.wallpapersapp.ui.fragments


import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpapersapp.databinding.FragmentHomeBinding
import com.example.wallpapersapp.paging.loadingState.LoadStateAdapter
import com.example.wallpapersapp.ui.fragments.base.BaseFragment
import com.example.wallpapersapp.ui.recyclerView.RecyclerViewAdapter
import com.example.wallpapersapp.ui.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter(this)
    private val viewModel: HomeViewModel by viewModels()
    override fun initViewModel() {
        lifecycleScope.launch {
            viewModel.homePage.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    override fun initRecyclerView() {
        val layoutManager = GridLayoutManager(context, 3)
        binding.rvHomeFragment.layoutManager = layoutManager
        binding.rvHomeFragment.adapter = recyclerViewAdapter.withLoadStateHeaderAndFooter(
            header = LoadStateAdapter{recyclerViewAdapter.retry()},
            footer = LoadStateAdapter{recyclerViewAdapter.retry()}
        )

       recyclerViewAdapter.addLoadStateListener { loadState ->
            binding.rvHomeFragment.isVisible = loadState.source.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = loadState.source.refresh is LoadState.Loading
            binding.buttonRetry.isVisible = loadState.source.refresh is LoadState.Error
            handelError(loadState)
        }
        binding.buttonRetry.setOnClickListener {
            recyclerViewAdapter.retry()
        }
    }





}