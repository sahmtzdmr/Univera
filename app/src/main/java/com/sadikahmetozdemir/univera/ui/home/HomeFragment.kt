package com.sadikahmetozdemir.univera.ui.home

import android.os.Bundle
import android.view.View
import com.sadikahmetozdemir.univera.R
import com.sadikahmetozdemir.univera.base.BaseFragment
import com.sadikahmetozdemir.univera.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    private lateinit var homeAdapter: HomeAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.albums.observe(viewLifecycleOwner) {
            homeAdapter = HomeAdapter(it)
            binding.recyclerView.apply {
                setHasFixedSize(true)
                adapter = homeAdapter
            }
            homeAdapter.itemClicked = {
                viewModel.toDetail(it)
            }

        }
    }
}