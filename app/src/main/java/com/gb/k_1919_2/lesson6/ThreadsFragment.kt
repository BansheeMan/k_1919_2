package com.gb.k_1919_2.lesson6

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
        val myThreads  = MyThreads()
        myThreads.start()
        with(binding){
            val time = editText.text.toString().toLong()
            var counter = 0
            button1.setOnClickListener {
                Thread{
                    sleep(time*1000L)
                    requireActivity().runOnUiThread { textView1.text = "$time сек. 1 " }
                    Handler(Looper.getMainLooper()).post {
                        textView1.text = "$time сек. 2"
                        createTextView("${Thread.currentThread().name} ${++counter}")
                    }

                }.start()
            }

            //"вечный поток"
            button2.setOnClickListener {
                myThreads.mHandler?.post {
                    sleep(time*1000L)
                    Handler(Looper.getMainLooper()).post {
                        textView2.text = "$time сек. 2"
                        createTextView("${Thread.currentThread().name} ${++counter}")}
                }
            }
        }
    }

    private fun createTextView(name:String) {
        binding.mainContainer.addView(TextView(requireContext()).apply {
            text = name
            textSize = 14f
        })
    }

    class MyThreads:Thread(){
        var mHandler:Handler?=null
        override fun run() {
            Looper.prepare()
            mHandler = Handler(Looper.myLooper()!!)
            Looper.loop()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ThreadsFragment()
    }

}

