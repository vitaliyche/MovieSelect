package com.codeliner.movieselect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.codeliner.movieselect.databinding.ActivityMainBinding
import com.codeliner.movieselect.databinding.FragmentMoviesBinding

class MainActivity : AppCompatActivity() {

    private var moviesBinding: ActivityMainBinding? = null
    private val binding get() = moviesBinding!!
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moviesBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this
        navController = Navigation.findNavController(this, R.id.nav_host)
    }

    override fun onDestroy() {
        super.onDestroy()
        moviesBinding = null

    }
}