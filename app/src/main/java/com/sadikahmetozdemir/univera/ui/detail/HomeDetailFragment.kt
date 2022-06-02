package com.sadikahmetozdemir.univera.ui.detail

import android.os.Bundle
import android.view.View
import com.sadikahmetozdemir.univera.R
import com.sadikahmetozdemir.univera.base.BaseFragment
import com.sadikahmetozdemir.univera.databinding.FragmentHomeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeDetailFragment :
    BaseFragment<FragmentHomeDetailBinding, HomeDetailViewModel>(R.layout.fragment_home_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lateinit var homeDetailAdapter: HomeDetailAdapter
        super.onViewCreated(view, savedInstanceState)

        viewModel.albumId?.let { viewModel.getPhotos(it) }
        viewModel.photos.observe(viewLifecycleOwner) {
            homeDetailAdapter = HomeDetailAdapter(it)
            binding.recyclerView.apply {
                setHasFixedSize(true)
                adapter = homeDetailAdapter
            }
            homeDetailAdapter.itemClicked = {
                viewModel.toComments(it)
            }

        }
    }
}