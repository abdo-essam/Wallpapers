package com.example.wallpapersapp.ui.recyclerView



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.example.wallpapersapp.R
import com.example.wallpapersapp.databinding.ItemRecyclerViewBinding
import com.example.wallpapersapp.model.Photo

class RecyclerViewAdapter(private val listener: WallpaperInteractionListener): PagingDataAdapter<Photo, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemRecyclerViewBinding.bind(view)

        fun bind(data: Photo) {
            Glide.with(itemView.context)
                .asBitmap()
                .load(data.src.large)
                .centerCrop()
                .transition(BitmapTransitionOptions.withCrossFade(80))
                .error(R.drawable.baseline_error_24)
                .into(binding.imageView)

            binding.imageView.setOnClickListener {
                listener.onClickItem(data, it)
            }
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return MyViewHolder(inflater)
    }

    class DiffUtilCallBack: DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }

    }
}

interface WallpaperInteractionListener {
    fun onClickItem(data: Photo, view: View)
}
