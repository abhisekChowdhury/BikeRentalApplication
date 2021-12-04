package com.example.bikeapplication.Fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.bikeapplication.R

public class DashboardFragmentDirections private constructor() {
  public companion object {
    public fun actionDashboardFragmentToBikeListingFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_bikeListingFragment)

    public fun actionDashboardFragmentToWeatherFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_weatherFragment)

    public fun actionDashboardFragmentToVendorFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_vendorFragment)
  }
}
