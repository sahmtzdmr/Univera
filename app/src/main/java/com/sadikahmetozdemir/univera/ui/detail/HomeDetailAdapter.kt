package com.sadikahmetozdemir.univera.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sadikahmetozdemir.univera.core.shared.remote.AlbumPhotosModelItem
import com.sadikahmetozdemir.univera.databinding.CustomPhotosItemBinding
import com.sadikahmetozdemir.univera.utils.extensions.load

class HomeDetailAdapter(private var photoList: List<AlbumPhotosModelItem>) :
    RecyclerView.Adapter<HomeDetailAdapter.ViewHolder>() {
    var itemClicked: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CustomPhotosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder((binding))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = photoList.get(position)
        album.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    inner class ViewHolder(val binding: CustomPhotosItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                tvTitle.setOnClickListener {
                    if (bindingAdapterPosition != RecyclerView.NO_POSITION) {
                        val currentItem = photoList.get(bindingAdapterPosition)
                        currentItem.let {
                            it.id?.let { it1 -> itemClicked?.invoke(it1) }
                        }
                    }
                }

            }
        }

        fun bind(item: AlbumPhotosModelItem) {
            binding.apply {
                ivAlbum.load(url = item.url)
                tvTitle.text = item.title


            }
        }
    }
}