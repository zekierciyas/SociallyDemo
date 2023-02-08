package com.zekierciyas.base

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat


fun ImageView.setDrawable(@DrawableRes drawable: Int) {
    this.setImageDrawable(ContextCompat.getDrawable(this.context, drawable))
}

fun Button.setBackground(@DrawableRes drawable: Int) {
    this.setBackgroundResource(drawable)
}
