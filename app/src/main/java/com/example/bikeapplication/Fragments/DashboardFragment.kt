package com.example.bikeapplication.Fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = FragmentDashboardBinding.inflate(inflater,container,false)
        setHasOptionsMenu(true)


        binding.btnWeather.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_weatherFragment)
        }

        binding.vendorButton.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToVendorFragment(args.userName)
            findNavController().navigate(action)
            //findNavController().navigate(R.id.action_dashboardFragment_to_vendorFragment)
        }

        binding.bikerButton.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToBikeListingFragment(args.userName)
            findNavController().navigate(action)
            //findNavController().navigate(R.id.action_dashboardFragment_to_bikeListingFragment)
        }

        binding.timerButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_timerFragment)
        }

        binding.btnLogout.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_loginFragment)
            }

        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val menuId = R.menu.menu
        inflater.inflate(menuId, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about -> findNavController().navigate(R.id.action_dashboardFragment_to_aboutFragment)
            R.id.help -> findNavController().navigate(R.id.action_dashboardFragment_to_helpFragment)
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}