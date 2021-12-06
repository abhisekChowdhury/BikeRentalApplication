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
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bikeapplication.Adapters.BikeListAdapter
import com.example.bikeapplication.R
import com.example.bikeapplication.ViewModel.MainViewModel
import com.example.bikeapplication.databinding.FragmentBikeListingBinding


class BikeListingFragment : Fragment(), BikeListAdapter.ListItemListener {
    private val args : DashboardFragmentArgs by navArgs()
    private lateinit var binding: FragmentBikeListingBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: BikeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = FragmentBikeListingBinding.inflate(inflater,container,false)

        with (binding.recyclerView) {
            setHasFixedSize(true) // all rows would have a fix size regardless of its contents

            // to create a divider to separate each row
            val divider = DividerItemDecoration(context, LinearLayoutManager(context).orientation)
            addItemDecoration(divider)
        }

        viewModel.backendBikeList()
        viewModel.liveDataList.observe(viewLifecycleOwner, Observer {
            if(it != null) {
                adapter = BikeListAdapter(it,this@BikeListingFragment)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(activity)
            }

            else {
                Log.i("error","no data found")
            }


        })

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_bikeListingFragment_to_dashboardFragment)
        }

        return binding.root

    }


    override fun onItemClick(bikeId: String) {

        val action = BikeListingFragmentDirections.actionBikeListingFragmentToDisplayBikeDetailsFragment(bikeId,args.userName)
        findNavController().navigate(action)
    }


}