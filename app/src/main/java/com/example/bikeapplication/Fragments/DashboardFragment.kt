package com.example.bikeapplication.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bikeapplication.R
import com.example.bikeapplication.ViewModel.MainViewModel
import com.example.bikeapplication.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private val args : DashboardFragmentArgs by navArgs()
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var viewModel: MainViewModel

//    val CITY: String = "vancouver,bc"
//    val API: String = "c8efb0bfd18451dfa4106515285bef09"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = FragmentDashboardBinding.inflate(inflater,container,false)


        binding.btnWeather.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_weatherFragment)
        }

        binding.vendorButton.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToVendorFragment(args.userName)
            findNavController().navigate(action)
            //findNavController().navigate(R.id.action_dashboardFragment_to_vendorFragment)
        }

        binding.bikerButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_bikeListingFragment)
        }


        viewModel.backendgetusernamepassword(args.userName)
        viewModel.liveDataUser.observe(viewLifecycleOwner, Observer {
            if(it != null) {
                Log.i("User in dashboard: ", it.FullName)
                binding.welcomeUserTextView.setText("Welcome, "+ it.FullName.toString()+" make sure you check today's weather before riding today!")
            }

            else {
                Log.i("error","no data found")
            }


        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)





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