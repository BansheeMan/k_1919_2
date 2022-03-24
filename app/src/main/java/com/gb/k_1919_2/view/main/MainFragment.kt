package com.gb.k_1919_2.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gb.k_1919_2.R
import com.gb.k_1919_2.databinding.FragmentMainBinding
import com.gb.k_1919_2.viewmodel.MainViewModel

class MainFragment : Fragment() {


    lateinit var binding:FragmentMainBinding// утечка памяти

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentMainBinding.inflate(inflater,container, false)
        //return inflater.inflate(R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOne.setOnClickListener {  }
       // view.findViewById<TextView>(R.id.btnOne).setOnClickListener {  }
       // view.findViewById<Button>(R.id.btnOne).setOnClickListener {  }

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //val observer = Observer<Any>{ renderData(it) }
        val observer = object:Observer<Any>{
            override fun onChanged(data: Any) {
                renderData(data)
            }
        }
        viewModel.getData().observe(viewLifecycleOwner,observer)
        viewModel.getWeather()
    }

    private fun renderData(data:Any){
        Toast.makeText(requireContext(),"РАБОТАЕТ",Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}