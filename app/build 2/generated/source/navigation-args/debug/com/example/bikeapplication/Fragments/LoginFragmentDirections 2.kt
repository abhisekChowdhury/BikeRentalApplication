package com.example.bikeapplication.Fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.bikeapplication.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToDashboardFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_dashboardFragment)
  }
}
