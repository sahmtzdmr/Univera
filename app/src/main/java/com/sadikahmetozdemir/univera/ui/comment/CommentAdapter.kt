package com.sadikahmetozdemir.univera.ui.comment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sadikahmetozdemir.univera.core.shared.remote.CommentResponseModelItem
import com.sadikahmetozdemir.univera.databinding.CustomCommentItemBinding

class CommentAdapter(private var commentList: List<CommentResponseModelItem>) :
    RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    var itemClicked: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CustomCommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder((binding))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = commentList.get(position)
        album.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    inner class ViewHolder(val binding: CustomCommentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CommentResponseModelItem) {
            binding.apply {
                tvBody.text = item.body
                tvEmail.text = item.email
                tvName.text = item.name


            }
        }
    }
}