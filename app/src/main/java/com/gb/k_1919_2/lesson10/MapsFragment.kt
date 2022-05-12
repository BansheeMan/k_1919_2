package com.gb.k_1919_2.lesson10

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Geocoder
import android.location.Location
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.gb.k_1919_2.R
import com.gb.k_1919_2.databinding.FragmentMapsMainBinding
import com.gb.k_1919_2.repository.City
import com.gb.k_1919_2.repository.Weather
import com.gb.k_1919_2.utlis.KEY_BUNDLE_WEATHER
import com.gb.k_1919_2.view.details.DetailsFragment

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import java.util.*
import kotlin.collections.ArrayList

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        map = googleMap
        val moscow = LatLng(55.0, 37.0)
        map.addMarker(MarkerOptions().position(moscow).title("Marker in Moscow"))
        map.moveCamera(CameraUpdateFactory.newLatLng(moscow))
        map.setOnMapLongClickListener {
            addMarkerToArray(it)
            drawLine()
        }
        map.setOnMapClickListener {
            val weather = Weather(city = City(getAddressByLocation(it), it.latitude, it.longitude))
            requireActivity().supportFragmentManager.beginTransaction().add(
                R.id.container,
                DetailsFragment.newInstance(Bundle().apply {
                    putParcelable(KEY_BUNDLE_WEATHER, weather)
                })
            ).addToBackStack("").commit()
        }
        map.uiSettings.isZoomControlsEnabled = true
        map.uiSettings.isMyLocationButtonEnabled = true
        map.isMyLocationEnabled = true

    }

    fun getAddressByLocation(location: LatLng):String{
        //val geocoder = Geocoder(requireContext())
        val geocoder = Geocoder(requireContext(), Locale.getDefault())
        val timeStump = System.currentTimeMillis()
        val addressText = geocoder.getFromLocation(location.latitude,location.longitude,1000000)[0].getAddressLine(0)
        return addressText
    }

    private lateinit var map: GoogleMap
    private val markers: ArrayList<Marker> = arrayListOf()


    private fun addMarkerToArray(location: LatLng) {
        val marker = setMarker(location, markers.size.toString(), R.drawable.ic_map_pin)
        markers.add(marker)
    }

    private fun drawLine(){
        var previousBefore: Marker? = null
        markers.forEach { current->
            previousBefore?.let{  previous->
                map.addPolyline(
                    PolylineOptions().add(previous.position,current.position)
                        .color(Color.RED)
                        .width(5f))
            }
            previousBefore = current
        }
    }




    private fun setMarker(
        location: LatLng,
        searchText: String,
        resourceId: Int
    ): Marker {
        return map.addMarker(
            MarkerOptions()
                .position(location)
                .title(searchText)
                .icon(BitmapDescriptorFactory.fromResource(resourceId))
        )!!
    }





    private var _binding: FragmentMapsMainBinding? = null
    private val binding: FragmentMapsMainBinding
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
        _binding = FragmentMapsMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}