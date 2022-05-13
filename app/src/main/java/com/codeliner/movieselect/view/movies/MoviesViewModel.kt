package com.codeliner.movieselect.view.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeliner.movieselect.data.retrofit.RetrofitRepository
import com.codeliner.movieselect.model.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MoviesViewModel: ViewModel() {
    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()

    fun getMovies() {
        viewModelScope.launch {
            try {
                myMovies.value = repository.getMovies()
            } catch (e:Exception) {
                Log.e("ERROR", e.message.toString())
            }

        }
    }
}