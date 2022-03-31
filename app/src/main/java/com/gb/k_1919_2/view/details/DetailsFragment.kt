package com.gb.k_1919_2.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gb.k_1919_2.databinding.FragmentDetailsBinding
import com.gb.k_1919_2.repository.Weather
import com.gb.k_1919_2.utlis.KEY_BUNDLE_WEATHER
import com.gb.k_1919_2.viewmodel.AppState
import com.google.android.material.snackbar.Snackbar

class DetailsFragment : Fragment() {


    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_main, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weather: Weather = requireArguments().getParcelable<Weather>(KEY_BUNDLE_WEATHER)!!
        renderData(weather)
    }

    private fun renderData(weather: Weather) {
        with(binding) {
            loadingLayout.visibility = View.GONE
            cityName.text = weather.city.name
            with(weather) {
                temperatureValue.text = temperature.toString()
                feelsLikeValue.text = feelsLike.toString()
                cityCoordinates.text = "${city.lat} ${city.lon}"
            }
            Snackbar.make(mainView, "Получилось", Snackbar.LENGTH_LONG).show()
        }

        //Toast.makeText(requireContext(),"РАБОТАЕТ",Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}

