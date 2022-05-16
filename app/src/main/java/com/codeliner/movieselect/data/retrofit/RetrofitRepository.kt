package com.codeliner.movieselect.data.retrofit

import com.codeliner.movieselect.data.retrofit.api.RetrofitInstance
import com.codeliner.movieselect.model.MoviesModel
import retrofit2.Response

class RetrofitRepository {
    suspend fun getMovies(): Response<MoviesModel> { //pageIndex: Int
        return RetrofitInstance.api.getMovieReview()
    }
}