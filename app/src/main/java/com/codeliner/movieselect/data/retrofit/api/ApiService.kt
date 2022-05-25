package com.codeliner.movieselect.data.retrofit.api

import com.codeliner.movieselect.model.MoviesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("svc/movies/v2/reviews/all.json?offset=1&order=by-opening-date&api-key=LvbO15TecPymntOrGGbBk9OCGqGhbZWC")
    suspend fun getMovieReview(): Response<MoviesModel>

    @GET("svc/movies/v2/reviews/all.json")
    suspend fun getMovieReview(
        @Query("offset") offset: Int,
        @Query("order") order: String = "by-opening-date",
        @Query("api-key") apiKey: String = "LvbO15TecPymntOrGGbBk9OCGqGhbZWC"
    ): MoviesModel
}