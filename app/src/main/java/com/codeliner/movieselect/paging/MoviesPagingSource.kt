package com.codeliner.movieselect.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.codeliner.movieselect.data.retrofit.api.ApiService
import com.codeliner.movieselect.model.MovieResult
import retrofit2.HttpException
import java.io.IOException

class MoviesPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, MovieResult>() {

    companion object {
        private const val MOVIES_STARTING_PAGE_OFFSET = 0
    }

    override fun getRefreshKey(state: PagingState<Int, MovieResult>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(20)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(20)
        }

        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    } //загрузить текущие данные при обновлении списка

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResult> {

        val offset = params.key ?: MOVIES_STARTING_PAGE_OFFSET
        return try {
            val response = apiService.getMovieReview(offset) //загрузить данные
            val movies = response.results
            val nextOffset = if (movies.isEmpty()) {
                null
            } else {
                offset + 20
            } //вычислить некст ки
            LoadResult.Page(
                data = movies,
                prevKey = null,
                nextKey = nextOffset
            ) //вернуть пейдж
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}