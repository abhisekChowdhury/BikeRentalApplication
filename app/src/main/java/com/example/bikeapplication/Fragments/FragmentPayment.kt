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
import com.example.bikeapplication.ViewModel.MainViewModel
import com.example.bikeapplication.databinding.FragmentPaymentBinding

class FragmentPayment : Fragment() {
    private val args : FragmentPaymentArgs by navArgs()
    private lateinit var binding: FragmentPaymentBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = FragmentPaymentBinding.inflate(inflater,container,false)

        viewModel.backendBikeDetails(args.selectedData)
        viewModel.backendgetusernamepassword(args.userName)

        binding.totalTextView.setText("$"+args.totalAmount)

        viewModel.liveDataUser.observe(viewLifecycleOwner, Observer {
            if(it != null) {
                var user:String = it.FullName
                binding.buttonBook.setOnClickListener {
                    val builder = AlertDialog.Builder(requireContext())
                    builder.setMessage("Order Confirmed, " + user + "!\n$" + args.totalAmount + " has been debited from your account.")
                        .setCancelable(false)
                        .setPositiveButton("Dashboard") { dialog, id ->
                            dialog.dismiss()
                            val action =
                                FragmentPaymentDirections.actionFragmentPaymentToDashboardFragment(
                                    args.userName
                                )
                            findNavController().navigate(action)
                        }
                    val alert = builder.create()
                    alert.show()
                }
            }else {
                Log.i("error","no data found")
            }
        })

        return binding.root
    }
}