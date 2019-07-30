package com.example.assignmentappspasybin.utils

import android.content.Context
import android.util.DisplayMetrics

fun convertDpToPixel(dp: Int, context: Context): Int {
    return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT).toInt()
}