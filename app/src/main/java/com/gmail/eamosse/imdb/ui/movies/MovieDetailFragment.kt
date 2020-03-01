package com.gmail.eamosse.imdb.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.gmail.eamosse.imdb.databinding.MovieDetailFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment: Fragment() {

    private val moviesViewModel: MovieViewModel by viewModel()
    private val args : MovieDetailFragmentArgs by navArgs()
    private lateinit var binding: MovieDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MovieDetailFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@MovieDetailFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(moviesViewModel) {
            getMovieDetail(args.movie)

            movie.observe(viewLifecycleOwner, Observer {
                // TODO: Get movie
            })

            error.observe(viewLifecycleOwner, Observer {
            })
        }
    }
}