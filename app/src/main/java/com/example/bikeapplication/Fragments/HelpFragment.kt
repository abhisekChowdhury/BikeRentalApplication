package com.example.bikeapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bikeapplication.R
import com.example.bikeapplication.databinding.FragmentAboutBinding
import com.example.bikeapplication.databinding.FragmentHelpBinding


class HelpFragment : Fragment() {

    private lateinit var binding: FragmentHelpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHelpBinding.inflate(inflater,container,false)

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_aboutFragment_to_dashboardFragment)
        }

        return binding.root
    }

}