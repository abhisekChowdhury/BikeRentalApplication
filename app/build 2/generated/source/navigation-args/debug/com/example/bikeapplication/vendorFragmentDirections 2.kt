package com.example.bikeapplication

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class vendorFragmentDirections private constructor() {
  public companion object {
    public fun actionVendorFragmentToAddBikeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_vendorFragment_to_addBikeFragment)
  }
}
