package com.sadikahmetozdemir.univera.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sadikahmetozdemir.univera.core.shared.remote.AlbumResponseModel
import com.sadikahmetozdemir.univera.core.shared.remote.AlbumResponseModelItem
import com.sadikahmetozdemir.univera.databinding.CustomAlbumItemBinding

class HomeAdapter(private var movieList: ArrayList<AlbumResponseModel>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CustomAlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder((binding))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = movieList.get(position)
        note.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class ViewHolder(val binding: CustomAlbumItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                tvDescription.setOnClickListener {
                    if (bindingAdapterPosition != RecyclerView.NO_POSITION) {
                        val currentItem = movieList.get(bindingAdapterPosition)
                        currentItem.let {
                            itemClicked?.invoke(it)
                        }
                    }
                }

            }
        }

        fun bind(item: AlbumResponseModelItem) {
            binding.apply {
                tvDescription.text = item.title
            }
        }
    }
}