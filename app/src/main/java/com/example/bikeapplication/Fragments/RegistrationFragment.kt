package com.example.bikeapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bikeapplication.R
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
         //   saveUser()
            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }

        return binding.root
    }

//
//    private fun saveUser() {
//        val fName = binding.etFirstName.text.toString().trim()
//        val lName = binding.etLastName.text.toString().trim()
//        val login = binding.etLogin.text.toString().trim()
//        val password = binding.etPassword.text.toString().trim()
//        val confirmPassword = binding.etConfirmPassword.text.toString().trim()
//
//        if(password.equals(confirmPassword)){
//           // viewModel.addUserAccount(Users(0, fName,lName,login,password,""))
//            Toast.makeText(requireActivity(), "User Saved", Toast.LENGTH_SHORT).show()
//            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
//        }else{
//            Toast.makeText(requireActivity(), "Passwords does not match", Toast.LENGTH_SHORT).show()
//        }
//    }
}