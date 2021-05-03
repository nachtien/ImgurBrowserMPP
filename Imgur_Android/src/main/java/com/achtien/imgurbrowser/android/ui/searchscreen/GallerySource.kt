package com.achtien.imgurbrowser.android.ui.searchscreen

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.achtien.imgurbrowser.remote.GalleryItem
import com.achtien.imgurbrowser.repository.ImgurRepository

class GalleryPagingSource(private val repository: ImgurRepository, private val query: String) : PagingSource<Int, GalleryItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GalleryItem> {

        val nextPage = params.key ?: 0
        val response = repository.searchForGallery(query = query, page = nextPage)

        return LoadResult.Page(
            data = response.data,
            prevKey = null,
            nextKey = nextPage +1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, GalleryItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
