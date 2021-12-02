package com.example.bikeapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bikeapplication.R
import com.example.bikeapplication.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnCancelLogin.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnUserLogin.setOnClickListener {
          //  checkUser()
            findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)

        }

        return binding.root
    }

//    private fun checkUser() {
//        val login = binding.etUserLogin.text.toString()
//        val password = binding.etUserPassword.text.toString()
//
//      //  viewModel.getUserAccount(login, password)
//
//
//
//     //   if(viewModel.userAccount != null){
//            findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
//        }
//    }
}