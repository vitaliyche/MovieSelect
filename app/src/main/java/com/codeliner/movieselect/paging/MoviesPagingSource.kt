package com.codeliner.movieselect.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.codeliner.movieselect.data.retrofit.api.ApiService
import com.codeliner.movieselect.model.MovieResult
import retrofit2.HttpException

//class MoviesPagingSource(
//    private val apiService: ApiService,
//    private val query: String
//) : PagingSource<Int, MovieResult>() {
//    override fun getRefreshKey(state: PagingState<Int, MovieResult>): Int? {
//        val anchorPosition = state.anchorPosition ?: return null
//        val page = state.closestPageToPosition(anchorPosition) ?: return null
//        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
//    } //загрузить текущие данные при обновлении списка
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResult> {
//        if (query.isEmpty()) {
//            return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
//        }
//
//        val page: Int = params.key ?: 1
        //val pageSize: Int = params.loadSize.coerceAtMost(ApiService) //.MAX_PAGE_SIZE

       // val response = apiService.getMovieReview(query, page, pageSize)
//        if (response.isSuccessful) {
//            val movies = checkNotNull(response.body()).results
//            val nextKey = if(movies.size < pageSize) null else page+1 //достигли конца
//            val prevKey = if (page ==1) null else page-1
//            return LoadResult.Page(movies, prevKey, nextKey)
//        } else {
           // return LoadResult .Error(HttpException(response))
//        } // обработать ситуацию с ошибкой
//    }
//}