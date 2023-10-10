package com.example.wallpapersapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.wallpapersapp.model.Photo
import com.example.wallpapersapp.networking.RetrofitServices

class HomePagingSource (
    private val apiServices: RetrofitServices
): PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val nextPage = params.key ?: CURRENT_PAGE_INDEX
            val responseHome = apiServices.getHomeResponse(nextPage)
            LoadResult.Page (
                data = responseHome.photos,
                prevKey = if(nextPage == 1) null else nextPage-1,
                nextKey = nextPage+1
//              nextKey = responseHome.page
            )

        } catch (e:Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val CURRENT_PAGE_INDEX = 1
    }

}