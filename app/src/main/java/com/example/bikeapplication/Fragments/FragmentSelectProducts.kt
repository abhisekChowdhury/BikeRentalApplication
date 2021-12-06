package com.example.bikeapplication.Fragments

import android.app.AlertDialog
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
import com.example.bikeapplication.databinding.FragmentSelectProductsBinding
import kotlinx.android.synthetic.main.fragment_select_products.*

class FragmentSelectProducts : Fragment() {

    private val args : FragmentSelectProductsArgs by navArgs()
    private lateinit var binding: FragmentSelectProductsBinding
    private lateinit var viewModel: MainViewModel
    private var totalPrice : Double = 0.0
    private var basePrice : Double = 0.0
    private var time: Double = 1.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = FragmentSelectProductsBinding.inflate(inflater,container,false)

        viewModel.backendBikeDetails(args.selectedData)

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSelectProducts_to_displayBikeDetailsFragment)
        }

        binding.buttonCancel.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSelectProducts_to_displayBikeDetailsFragment)
        }

        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            if(it != null) {

                basePrice = it.Price.toDouble()
                totalPrice = basePrice


                binding.buttonBook.setOnClickListener {
                    time = binding.editTextTime.text.toString().toDoubleOrNull()?:0.0
                    totalPrice *= time
                    if (checkBoxHelmet.isChecked){
                        totalPrice += 2
                    }
                    if (checkBoxLock.isChecked){
                        totalPrice += 3
                    }
                    if (checkBoxBasket.isChecked){
                        totalPrice += 2
                    }
                    if (checkBoxPhoneStand.isChecked){
                        totalPrice += 2
                    }
                    Log.i("Total Price: ", totalPrice.toString())
                    binding.totalTextView.setText("Total $"+totalPrice.toString())


                    val builder = AlertDialog.Builder(requireContext())
                    builder.setMessage("Total cost is $"+totalPrice+", would you like to proceed with payment?")
                        .setCancelable(false)
                        .setPositiveButton("Yes") { dialog, id ->
                            val action = FragmentSelectProductsDirections.actionFragmentSelectProductsToFragmentPayment(args.selectedData, args.userName, totalPrice.toString())
                            findNavController().navigate(action)
                        }
                        .setNegativeButton("No") { dialog, id ->
                            // Dismiss the dialog
                            totalPrice = basePrice
                            checkBoxHelmet.isChecked = false
                            checkBoxLock.isChecked = false
                            checkBoxBasket.isChecked = false
                            checkBoxPhoneStand.isChecked = false

                            dialog.dismiss()
                        }
                    val alert = builder.create()
                    alert.show()

                }

            }

            else {
                Log.i("error","no data found")
            }


        })

        return binding.root
    }
}