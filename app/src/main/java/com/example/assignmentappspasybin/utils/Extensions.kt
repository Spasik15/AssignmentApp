package com.example.assignmentappspasybin.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import com.example.assignmentappspasybin.utils.MyAnimation.Companion.ALPHA_0
import com.example.assignmentappspasybin.utils.MyAnimation.Companion.ALPHA_1
import com.example.assignmentappspasybin.utils.MyAnimation.Companion.DEFAULT_DURATION

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun View.showView(duration: Long) {
    MyAnimation
        .alpha(this, duration, ALPHA_0, ALPHA_1)
        .start()
    isEnabled = true
}

fun View.showView() {
    showView(DEFAULT_DURATION)
}

fun View.hideView(duration: Long) {
    if (alpha != ALPHA_0)
        MyAnimation
            .alpha(this, duration, ALPHA_1, ALPHA_0)
            .start()
    isEnabled = false
}

fun View.hideView() {
    hideView(DEFAULT_DURATION)
}