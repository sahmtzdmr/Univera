package com.sadikahmetozdemir.univera.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sadikahmetozdemir.univera.R

fun ImageView.load(isFadeInEnabled: Boolean = true, url: String?) {
    val duration = if (isFadeInEnabled)50 else 0
    Glide
        .with(context)
        .load(url)
        .error(R.drawable.logo)
        .transition(DrawableTransitionOptions.withCrossFade(duration))
        .into(this)
}
