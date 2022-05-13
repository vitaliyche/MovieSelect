package com.codeliner.movieselect.model

data class MoviesModel(
    val copyright: String,
    val has_more: Boolean,
    val num_results: Int,
    val results: List<MovieResult>,
    val status: String
)