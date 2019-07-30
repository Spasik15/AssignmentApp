package com.example.assignmentappspasybin.utils

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Interpolator
import androidx.core.view.animation.PathInterpolatorCompat

class MyAnimation {

    companion object {
        const val DEFAULT_DURATION = 350L
        const val LONG_DURATION = 700L
        const val ALPHA_0 = 0f
        const val ALPHA_1 = 1f

        private val bezierInterpolator: Interpolator = PathInterpolatorCompat.create(0.42f, 0f, 0.58f, 1f)
        private val acInterpolator = AccelerateDecelerateInterpolator()

        private fun alpha(view: View, vararg values: Float): ObjectAnimator {
            return ObjectAnimator.ofFloat(view, View.ALPHA, *values)
        }

        fun alpha(view: View, duration: Long, vararg values: Float): ObjectAnimator {
            return alpha(view, *values).apply {
                this.duration = duration
                this.interpolator = acInterpolator
            }
        }

        private fun alongY(view: View, vararg values: Float): ObjectAnimator {
            return ObjectAnimator.ofFloat(view, View.Y, *values)
        }

        fun alongY(view: View, duration: Long, vararg values: Float): ObjectAnimator {
            return alongY(view, *values).apply {
                this.duration = duration
                this.interpolator = bezierInterpolator
            }
        }
    }
}