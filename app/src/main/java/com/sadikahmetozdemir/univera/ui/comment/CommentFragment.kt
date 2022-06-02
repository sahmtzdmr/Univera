package com.sadikahmetozdemir.univera.ui.comment

import android.os.Bundle
import android.view.View
import com.sadikahmetozdemir.univera.R
import com.sadikahmetozdemir.univera.base.BaseFragment
import com.sadikahmetozdemir.univera.databinding.FragmentCommentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommentFragment :
    BaseFragment<FragmentCommentBinding, CommentViewModel>(R.layout.fragment_comment) {
    lateinit var commentAdapter: CommentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.albumId?.let { viewModel.getComments(it, 7) }
        viewModel.comments.observe(viewLifecycleOwner) {
            commentAdapter = CommentAdapter(it)
            binding.recyclerView.apply {
                setHasFixedSize(true)
                adapter = commentAdapter
            }
        }
    }
}
