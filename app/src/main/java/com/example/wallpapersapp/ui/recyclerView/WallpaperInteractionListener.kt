package com.example.wallpapersapp.ui.recyclerView

import android.view.View
import com.example.wallpapersapp.model.Photo

interface WallpaperInteractionListener {
    fun onClickItem(data: Photo, view: View)
}
