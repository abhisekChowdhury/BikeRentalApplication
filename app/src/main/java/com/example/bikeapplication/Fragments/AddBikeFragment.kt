package com.example.bikeapplication.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bikeapplication.Entities.SingleBikeEntity
import com.example.bikeapplication.R
import com.example.bikeapplication.ViewModel.MainViewModel
import com.example.bikeapplication.databinding.FragmentAddBikeBinding

class addBikeFragment : Fragment() {
    private val args : DashboardFragmentArgs by navArgs()
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
        var radioButtonText : String = "";


        binding.addBikeButton.setOnClickListener {
            val VendorName = args.userName
            val BrandName = binding.editTextTextBrandName.text.toString()
            val BikeType = binding.editTextTextBikeType.text.toString()
            val UserTypeID = binding.userTypeRadioGroup.checkedRadioButtonId
            when(UserTypeID){
                R.id.kidsRadioButton -> radioButtonText = "Kids"
                R.id.adultsRadioButton -> radioButtonText = "Adults"
                else -> radioButtonText = "Unknown"
            }

            val Description = binding.editTextDescription.text.toString()
            val Price = binding.editTextPrice.text.toString().toString()
            val Location = binding.spinnerLocation.selectedItem.toString()
            Log.i("Data: ", "Vendor: " + VendorName + " BrandName: "+BrandName+ " BikeType: "+BikeType+ " UserType: "+radioButtonText + " Description: "+ Description + " Location: "+ Location)

            val bike = SingleBikeEntity(BikeType,BrandName,Description,Location, radioButtonText,VendorName, Price)

            viewModel.backendAddBike(bike)

            //findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
            Toast.makeText(requireContext(), "$BrandName Bike Added!", Toast.LENGTH_SHORT).show()
        }




        return binding.root
    }

}