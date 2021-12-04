package com.example.bikeapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bikeapplication.R
import com.example.bikeapplication.ViewModel.MainViewModel
import com.example.bikeapplication.databinding.FragmentAddBikeBinding
import com.example.bikeapplication.databinding.FragmentDisplayBikeDetailsBinding
import com.example.bikeapplication.databinding.FragmentVendorBinding

class addBikeFragment : Fragment() {
    private lateinit var binding: FragmentAddBikeBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = FragmentAddBikeBinding.inflate(inflater,container,false)





        return binding.root
    }

}