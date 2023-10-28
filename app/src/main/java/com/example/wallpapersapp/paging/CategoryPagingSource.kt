package com.example.wallpapersapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.wallpapersapp.model.Photo
import com.example.wallpapersapp.networking.RetrofitServices


class CategoryPagingSource (private val apiService: RetrofitServices, private val category : String) :
    PagingSource<Int,Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val nextPage = params.key ?: FIRST_PAGE_INDEX
            val responsePopular = apiService.getCategoryResponse(nextPage,category)
            LoadResult.Page(
                data = responsePopular.photos,
                prevKey = null,
                nextKey = nextPage+1,
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }

}