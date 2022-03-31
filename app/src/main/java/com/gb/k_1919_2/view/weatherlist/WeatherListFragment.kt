package com.gb.k_1919_2.view.weatherlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gb.k_1919_2.R
import com.gb.k_1919_2.databinding.FragmentWeatherListBinding
import com.gb.k_1919_2.repository.Weather
import com.gb.k_1919_2.utlis.KEY_BUNDLE_WEATHER
import com.gb.k_1919_2.view.MainActivity
import com.gb.k_1919_2.view.details.DetailsFragment
import com.gb.k_1919_2.viewmodel.AppState
import com.gb.k_1919_2.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class WeatherListFragment : Fragment(),OnItemListClickListener {


    private var _binding: FragmentWeatherListBinding? = null
    private val binding: FragmentWeatherListBinding
        get() {
            return _binding!!
        }

    private val adapter = WeatherListAdapter(this)

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherListBinding.inflate(inflater, container, false)
        return binding.root
    }

    var isRussian = true
    private val viewModel:MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.also {// TODO HW вынесты в initRecycler()
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(requireContext())
        }
        val observer = {data: AppState -> renderData(data)}
        viewModel.getData().observe(viewLifecycleOwner, observer)
        setupFab()
        viewModel.getWeatherRussia()
    }

    private fun setupFab() {
        binding.floatingActionButton.setOnClickListener {
            isRussian = !isRussian
            if (isRussian) {
                viewModel.getWeatherRussia()
                binding.floatingActionButton.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_russia
                    )
                )
            } else {
                binding.floatingActionButton.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_earth
                    )
                )
                viewModel.getWeatherWorld()
            }
        }
    }

    private fun renderData(data: AppState) {
        when (data) {
            is AppState.Error -> {
                binding.loadingLayout.visibility = View.GONE
                Snackbar.make(binding.root, "Не получилось ${data.error}", Snackbar.LENGTH_LONG)
                    .show()
            }
            is AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Success -> {
                binding.loadingLayout.visibility = View.GONE
                adapter.setData(data.weatherList)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = WeatherListFragment()
    }

    override fun onItemClick(weather: Weather) {
        requireActivity().supportFragmentManager.beginTransaction().add(
            R.id.container,
            DetailsFragment.newInstance(Bundle().apply {
                putParcelable(KEY_BUNDLE_WEATHER, weather)
            })
        ).addToBackStack("").commit()
    }
}

