// Generated by view binder compiler. Do not edit!
package com.example.bikeapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.bikeapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDisplayBikeDetailsBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ScrollView bikeDescription;

  @NonNull
  public final ImageView bikeImage;

  @NonNull
  public final TextView bikePriceTextView;

  @NonNull
  public final TextView bikeTitleTextView;

  @NonNull
  public final Button bookBikeButton;

  @NonNull
  public final Button cancelButton;

  @NonNull
  public final TextView commentsTextView;

  @NonNull
  public final TextView descriptionTextView;

  @NonNull
  public final TextView ratingTextView;

  private FragmentDisplayBikeDetailsBinding(@NonNull FrameLayout rootView,
      @NonNull ScrollView bikeDescription, @NonNull ImageView bikeImage,
      @NonNull TextView bikePriceTextView, @NonNull TextView bikeTitleTextView,
      @NonNull Button bookBikeButton, @NonNull Button cancelButton,
      @NonNull TextView commentsTextView, @NonNull TextView descriptionTextView,
      @NonNull TextView ratingTextView) {
    this.rootView = rootView;
    this.bikeDescription = bikeDescription;
    this.bikeImage = bikeImage;
    this.bikePriceTextView = bikePriceTextView;
    this.bikeTitleTextView = bikeTitleTextView;
    this.bookBikeButton = bookBikeButton;
    this.cancelButton = cancelButton;
    this.commentsTextView = commentsTextView;
    this.descriptionTextView = descriptionTextView;
    this.ratingTextView = ratingTextView;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDisplayBikeDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDisplayBikeDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_display_bike_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDisplayBikeDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bikeDescription;
      ScrollView bikeDescription = ViewBindings.findChildViewById(rootView, id);
      if (bikeDescription == null) {
        break missingId;
      }

      id = R.id.bikeImage;
      ImageView bikeImage = ViewBindings.findChildViewById(rootView, id);
      if (bikeImage == null) {
        break missingId;
      }

      id = R.id.bikePriceTextView;
      TextView bikePriceTextView = ViewBindings.findChildViewById(rootView, id);
      if (bikePriceTextView == null) {
        break missingId;
      }

      id = R.id.bikeTitleTextView;
      TextView bikeTitleTextView = ViewBindings.findChildViewById(rootView, id);
      if (bikeTitleTextView == null) {
        break missingId;
      }

      id = R.id.bookBikeButton;
      Button bookBikeButton = ViewBindings.findChildViewById(rootView, id);
      if (bookBikeButton == null) {
        break missingId;
      }

      id = R.id.cancelButton;
      Button cancelButton = ViewBindings.findChildViewById(rootView, id);
      if (cancelButton == null) {
        break missingId;
      }

      id = R.id.pickupLocationTextView;
      TextView commentsTextView = ViewBindings.findChildViewById(rootView, id);
      if (commentsTextView == null) {
        break missingId;
      }

      id = R.id.descriptionTextView;
      TextView descriptionTextView = ViewBindings.findChildViewById(rootView, id);
      if (descriptionTextView == null) {
        break missingId;
      }

      id = R.id.vendorTextView;
      TextView ratingTextView = ViewBindings.findChildViewById(rootView, id);
      if (ratingTextView == null) {
        break missingId;
      }

      return new FragmentDisplayBikeDetailsBinding((FrameLayout) rootView, bikeDescription,
          bikeImage, bikePriceTextView, bikeTitleTextView, bookBikeButton, cancelButton,
          commentsTextView, descriptionTextView, ratingTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
