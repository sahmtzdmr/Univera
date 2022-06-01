package com.sadikahmetozdemir.univera.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.sadikahmetozdemir.univera.R
import com.sadikahmetozdemir.univera.base.BaseFragment
import com.sadikahmetozdemir.univera.core.shared.remote.AlbumResponseModel
import com.sadikahmetozdemir.univera.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    private lateinit var homeAdapter: HomeAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch{
            viewModel.getAlbums()
        }
        viewModel.albums.observe(viewLifecycleOwner){
        val albumList=ArrayList<AlbumResponseModel>()
        albumList.add(it)
            homeAdapter= HomeAdapter(albumList)
            binding.recyclerView.apply {
                setHasFixedSize(true)
                adapter = homeAdapter
            }



        }
    }




}