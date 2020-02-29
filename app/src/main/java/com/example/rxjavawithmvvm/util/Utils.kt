package com.example.rxjavawithmvvm.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class Utils {
    companion object {
        @JvmStatic
        @BindingAdapter("image_url")
        fun setImage(view: ImageView, image_url: String) {
            image_url?.let {
                Picasso.get().load(image_url).into(view)
            }
        }
    }

}