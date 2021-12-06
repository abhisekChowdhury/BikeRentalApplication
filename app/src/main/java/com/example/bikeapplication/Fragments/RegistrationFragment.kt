package com.example.bikeapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bikeapplication.Entities.SingleUserEntity
import com.example.bikeapplication.R
import com.example.bikeapplication.ViewModel.MainViewModel
import com.example.bikeapplication.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    private lateinit var binding: FragmentRegistrationBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnCancel.setOnClickListener {
            findNavController().navigateUp()

        }


        binding.btnSaveUser.setOnClickListener {
            if (binding.etPassword.text.toString() == binding.etConfirmPassword.text.toString()) {
                val fullName = binding.etName.text.toString()
                val userName = binding.etUserName.text.toString()
                val address = binding.etAddress.text.toString()
                val password = binding.etPassword.text.toString()

                val user = SingleUserEntity(fullName, userName, address, password)

                viewModel.backendAddUser(user)

                findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
            }else{
                Toast.makeText(requireContext(),"Please check your password!",Toast.LENGTH_LONG).show()
            }
        }


        return binding.root
    }

}