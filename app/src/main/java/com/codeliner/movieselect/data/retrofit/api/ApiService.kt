package com.codeliner.movieselect.data.retrofit.api

import com.codeliner.movieselect.model.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("svc/movies/v2/reviews/all.json?order=by-opening-date&api-key=LvbO15TecPymntOrGGbBk9OCGqGhbZWC")
    suspend fun getMovieReview(): Response<MoviesModel>
}