package com.example.bikeapplication.Fragments

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bikeapplication.R
import com.example.bikeapplication.databinding.FragmentDashboardBinding
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding
    private lateinit var viewModel: MainViewModel

    val CITY: String = "vancouver,bc"
    val API: String = "c8efb0bfd18451dfa4106515285bef09"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = FragmentDashboardBinding.inflate(inflater,container,false)



        binding.vendorButton.setOnClickListener {
            //Make Vendor Form
        }

        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        bikerButton.setOnClickListener {
            findNavController().navigate(R.id.bikeListingFragment)
        }

        //weatherTask().execute()
    }

//    inner class weatherTask() : AsyncTask<String, Void, String>()
//    {
//        override fun onPreExecute() {
//            super.onPreExecute()
//
//        }
//    }


}