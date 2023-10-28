package com.example.wallpapersapp.ui.recyclerView

import android.view.View
import com.example.wallpapersapp.model.Category


interface CategoryInteractionListener {
    fun onClickCategory(category : Category, view: View)
}