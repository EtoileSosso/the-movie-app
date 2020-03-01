package com.gmail.eamosse.imdb.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.gmail.eamosse.imdb.databinding.MoviesFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private val moviesViewModel: MovieViewModel by viewModel()
    private val args : MoviesFragmentArgs by navArgs()
    private lateinit var binding: MoviesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MoviesFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@MoviesFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(moviesViewModel) {
            getMovies(args.category)

            movies.observe(viewLifecycleOwner, Observer {
                binding.moviesList.adapter = MovieAdapter(it) { movie ->
                    val action =
                        MoviesFragmentDirections.actionMoviesFragmentToMovieDetail(movie.id)
                    findNavController().navigate(action)
                }
            })

            error.observe(viewLifecycleOwner, Observer {
            })
        }
    }
}