package com.example.wallpapersapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.wallpapersapp.model.Photo
import com.example.wallpapersapp.networking.RetrofitServices

class PopularPagingSource(
    private val apiService: RetrofitServices
) : PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val nextPage = params.key ?: FIRST_PAGE_INDEX
            val responsePopular = apiService.getPopularResponse(nextPage)
            //Log.d("main123",responsePopular.photos.toString())
            LoadResult.Page(
                data = responsePopular.photos,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (e: Exception) {
            //Log.d("main123",e.toString())
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }
}