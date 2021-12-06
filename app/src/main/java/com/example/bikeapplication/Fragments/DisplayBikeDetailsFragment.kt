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
import com.example.bikeapplication.ViewModel.MainViewModel
import com.example.bikeapplication.R
import com.example.bikeapplication.databinding.FragmentDisplayBikeDetailsBinding
import kotlinx.android.synthetic.main.fragment_display_bike_details.*
import kotlinx.android.synthetic.main.list_item.*

class DisplayBikeDetailsFragment : Fragment() {
    private val args : DisplayBikeDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentDisplayBikeDetailsBinding
    private lateinit var viewModel: MainViewModel
    private var pickupLocation:String = ""

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

                when {
                    it.Brand.equals("GIANT",ignoreCase = true) -> {
                        binding.bikeImage.setImageResource(R.drawable.bike1)
                        Log.i("Giant", "If works!")
                    }
                    it.Brand.equals("LIV",ignoreCase = true) -> {
                        binding.bikeImage.setImageResource(R.drawable.bike2)
                    }
                    it.Brand.equals("HERO",ignoreCase = true) -> {
                        binding.bikeImage.setImageResource(R.drawable.bike3)
                    }
                    it.Brand.equals("HERCULES",ignoreCase = true) -> {
                        binding.bikeImage.setImageResource(R.drawable.bike4)
                    }
                    it.Brand.equals("TREK",ignoreCase = true) -> {
                        binding.bikeImage.setImageResource(R.drawable.bike5)
                    }
                    else -> {
                        binding.bikeImage.setImageResource(R.drawable.bello_logos_transparent)
                    }
                }

                binding.bikeTitleTextView.setText(it.Brand.toString() + it.BikeType.toString())
                Log.i("bike",it.Brand)
                //binding.bikeImage.setImageResource(R.drawable.common_full_open_on_phone)
                binding.bikePriceTextView.setText("$"+it.Price)
                binding.descriptionTextView.setText("Description: " + it.Description)
//                binding.ratingTextView.setText("Rating:" + it.UserRating)
//                binding.commentsTextView.setText("User Comments: " + it.UserComments)

                pickupLocation = it.PickupLocation



                binding.checkMapButton.setOnClickListener {
                    val action = DisplayBikeDetailsFragmentDirections.actionDisplayBikeDetailsFragmentToMapsFragment(pickupLocation)
                    findNavController().navigate(action)
                }

                binding.bookBikeButton.setOnClickListener {
                    val action = DisplayBikeDetailsFragmentDirections.actionDisplayBikeDetailsFragmentToFragmentSelectProducts(args.selectedData, args.userName)
                    findNavController().navigate(action)
                }


            }

            else {
                Log.i("error","no data found")
            }

        })

        return binding.root
    }
}