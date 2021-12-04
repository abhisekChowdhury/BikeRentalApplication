package com.example.bikeapplication.Fragments

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.bikeapplication.R
import kotlin.Int
import kotlin.String

public class BikeListingFragmentDirections private constructor() {
  private data class ActionBikeListingFragmentToDisplayBikeDetailsFragment(
    public val selectedData: String
  ) : NavDirections {
    public override fun getActionId(): Int =
        R.id.action_bikeListingFragment_to_displayBikeDetailsFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("selectedData", this.selectedData)
      return result
    }
  }

  public companion object {
    public fun actionBikeListingFragmentToDisplayBikeDetailsFragment(selectedData: String):
        NavDirections = ActionBikeListingFragmentToDisplayBikeDetailsFragment(selectedData)
  }
}
