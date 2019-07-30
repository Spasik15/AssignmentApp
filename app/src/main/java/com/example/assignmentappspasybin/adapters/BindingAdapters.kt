package com.example.assignmentappspasybin.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

@BindingAdapter("imageUrl")
fun loadImageFromUrl(view: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(view.context)
            .load(it)
            .transition(DrawableTransitionOptions.withCrossFade())
            .transform(RoundedCornersTransformation(10, 0))
            .into(view)
    }
}