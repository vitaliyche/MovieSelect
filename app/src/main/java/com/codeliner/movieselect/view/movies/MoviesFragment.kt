package com.codeliner.movieselect.view.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.codeliner.movieselect.databinding.FragmentMoviesBinding
import kotlinx.coroutines.flow.collectLatest

class MoviesFragment : Fragment() {

    private var moviesBinding: FragmentMoviesBinding ?= null
    private val binding get() = moviesBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MoviesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        moviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        viewModel.getMovies()
        recyclerView = binding.moviesRv
        recyclerView.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.pagingMoviesFlow.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        moviesBinding = null
    }
}