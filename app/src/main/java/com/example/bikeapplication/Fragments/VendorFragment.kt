package com.example.bikeapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bikeapplication.Fragments.DashboardFragmentArgs
import com.example.bikeapplication.Fragments.DashboardFragmentDirections
import com.example.bikeapplication.ViewModel.MainViewModel
import com.example.bikeapplication.databinding.FragmentVendorBinding

class vendorFragment : Fragment() {
    private val args : DashboardFragmentArgs by navArgs()
    private lateinit var binding: FragmentVendorBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(
        savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = FragmentVendorBinding.inflate(inflater,container,false)


        binding.addBikeButton.setOnClickListener {
            val action = vendorFragmentDirections.actionVendorFragmentToAddBikeFragment(args.userName)
            findNavController().navigate(action)
        }

        return binding.root
    }

}