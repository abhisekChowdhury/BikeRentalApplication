package com.example.bikeapplication.Fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.bikeapplication.R

public class RegistrationFragmentDirections private constructor() {
  public companion object {
    public fun actionRegistrationFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_registrationFragment_to_loginFragment)
  }
}
