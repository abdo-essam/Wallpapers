package com.example.wallpapersapp.ui.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpapersapp.R
import com.example.wallpapersapp.databinding.CategoryItemRowBinding
import com.example.wallpapersapp.model.Category

class CategoryAdapter(private val categoryList: List<Category> , private val listener: CategoryInteractionListener): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    inner class CategoryViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val binding = CategoryItemRowBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item_row,parent,false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int  = categoryList.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentCategory = categoryList[position]
        holder.binding.apply {
            tvCategory.text = currentCategory.categoryName
            Glide.with(holder.itemView.context)
                .load(currentCategory.imageUrl)
                .centerCrop()
                .error(R.drawable.baseline_error_24)
                .into(ivCategory)
        }

        holder.binding.ivCategory.setOnClickListener {
            listener.onClickCategory(currentCategory, it)
        }
    }
}