package com.gb.k_1919_2.lesson6

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gb.k_1919_2.R
import com.gb.k_1919_2.databinding.FragmentThreadsBinding
import com.gb.k_1919_2.databinding.FragmentWeatherListBinding
import com.gb.k_1919_2.repository.Weather
import com.gb.k_1919_2.utlis.KEY_BUNDLE_WEATHER
import com.gb.k_1919_2.view.MainActivity
import com.gb.k_1919_2.view.details.DetailsFragment
import com.gb.k_1919_2.view.weatherlist.OnItemListClickListener
import com.gb.k_1919_2.view.weatherlist.WeatherListAdapter
import com.gb.k_1919_2.viewmodel.AppState
import com.gb.k_1919_2.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import java.lang.Thread.sleep

class ThreadsFragment : Fragment() {

    private var _binding: FragmentThreadsBinding? = null
    private val binding: FragmentThreadsBinding
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
    ): View {
        _binding = FragmentThreadsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            button.setOnClickListener {
                Thread{
                    val time = editText.text.toString().toLong()
                    sleep(time*1000L)
                    requireActivity().runOnUiThread { textView.text = "$time сек. 1 " }
                    Handler(Looper.getMainLooper()).post { textView.text = "$time сек. 2" }
                }.start()
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = ThreadsFragment()
    }

}

