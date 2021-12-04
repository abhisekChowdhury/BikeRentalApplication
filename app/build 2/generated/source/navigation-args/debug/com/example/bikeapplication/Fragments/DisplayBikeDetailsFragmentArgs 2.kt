package com.example.bikeapplication.Fragments

import android.os.Bundle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class DisplayBikeDetailsFragmentArgs(
  public val selectedData: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("selectedData", this.selectedData)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DisplayBikeDetailsFragmentArgs {
      bundle.setClassLoader(DisplayBikeDetailsFragmentArgs::class.java.classLoader)
      val __selectedData : String?
      if (bundle.containsKey("selectedData")) {
        __selectedData = bundle.getString("selectedData")
        if (__selectedData == null) {
          throw IllegalArgumentException("Argument \"selectedData\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"selectedData\" is missing and does not have an android:defaultValue")
      }
      return DisplayBikeDetailsFragmentArgs(__selectedData)
    }
  }
}
