package com.example.bikeapplication.Fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.bikeapplication.R

public class MainFragmentDirections private constructor() {
  public companion object {
    public fun actionMainFragmentToRegistrationFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainFragment_to_registrationFragment)

    public fun actionMainFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainFragment_to_loginFragment)
  }
}
