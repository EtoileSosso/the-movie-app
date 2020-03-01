package com.gmail.eamosse.imdb.ui.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.gmail.eamosse.imdb.databinding.TrendingFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrendingFragment : Fragment() {

    private val trendingViewModel: TrendingViewModel by viewModel()
    private lateinit var binding: TrendingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TrendingFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@TrendingFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(trendingViewModel) {
            loadTrendingMovies()
            loadTrendingCategories()
            loadTrendingPeople()

            trending.observe(viewLifecycleOwner, Observer {
                binding.trendingMovies.trendingItems.adapter = TrendingMovieAdapter(it)
            })

            categories.observe(viewLifecycleOwner, Observer {
                binding.trendingCategories.trendingItems.adapter = TrendingCategoryAdapter(it)

            })

            people.observe(viewLifecycleOwner, Observer {
                binding.trendingPeople.trendingItems.adapter = TrendingPersonAdapter(it)
            })

            error.observe(viewLifecycleOwner, Observer {
            })
        }
    }
}
