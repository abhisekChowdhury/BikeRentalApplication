package com.example.bikeapplication.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.HapticFeedbackConstants
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bikeapplication.R
import com.example.bikeapplication.ViewModel.MainViewModel
import com.example.bikeapplication.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var auth: FirebaseAuth
    private lateinit var TAG: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        auth = FirebaseAuth.getInstance()
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnCancelLogin.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnUserLogin.setOnClickListener {
          //  checkUser()

            val userName = binding.etUserLogin.text.toString()
            val password = binding.etUserPassword.text.toString()

            viewModel.backendgetusernamepassword(userName)
            viewModel.liveDataUser.observe(viewLifecycleOwner, Observer {
                if(it != null) {
                    if (it.Password == password) {
                        findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                    }else{
                        Toast.makeText(requireContext(), "Please check the password!", Toast.LENGTH_LONG).show()
                    }
//                    binding.bikeImage.setImageResource(R.drawable.common_full_open_on_phone)
//                    binding.bikePriceTextView.setText(it.Price)
//                    binding.descriptionTextView.setText("Description: " + it.Description)
//                    binding.ratingTextView.setText("Rating:" + it.UserRating)
//                    binding.commentsTextView.setText("User Comments: " + it.UserComments)
                }

                else {
                    Log.i("error","no data found")
                }


        })
        }

        return binding.root
    }

    private fun login(){
        if(binding.etUserLogin.text.toString().trim() != "" && binding.etUserPassword.text.toString().trim() != "") {
            HapticFeedbackConstants.VIRTUAL_KEY
            auth.signInWithEmailAndPassword(
                binding.etUserLogin.text.toString(),
                binding.etUserPassword.text.toString()
            )
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "signInWithEmail:success")

                        Toast.makeText(
                            context, "Authentication Success.",
                            Toast.LENGTH_SHORT
                        ).show()
                        findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                    } else {
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            context, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    // [START_EXCLUDE]
                    if (!task.isSuccessful) {
                        Toast.makeText(context, "Please enter valid username and password.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        else{
            Toast.makeText(context, "Please enter valid username and password.", Toast.LENGTH_SHORT).show()
        }
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