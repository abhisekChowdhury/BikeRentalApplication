package com.example.bikeapplication.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.bikeapplication.ViewModel.MainViewModel
import com.example.bikeapplication.R
import com.example.bikeapplication.databinding.FragmentDisplayBikeDetailsBinding

class DisplayBikeDetailsFragment : Fragment() {
    private val args : DisplayBikeDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentDisplayBikeDetailsBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = FragmentDisplayBikeDetailsBinding.inflate(inflater,container,false)

        viewModel.backendBikeDetails(args.selectedData)
        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            if(it != null) {
                binding.bikeTitleTextView.setText(it.Brand.toString() + it.BikeType.toString())
                Log.i("bike",it.Brand)
                binding.bikeImage.setImageResource(R.drawable.common_full_open_on_phone)
                binding.bikePriceTextView.setText(it.Price)
                binding.descriptionTextView.setText("Description: " + it.Description)
                binding.ratingTextView.setText("Rating:" + it.UserRating)
                binding.commentsTextView.setText("User Comments: " + it.UserComments)
            }

            else {
                Log.i("error","no data found")
            }


        })

        return binding.root
    }
}