package com.miartg.draw.styles

import android.graphics.Paint

data class Stroke(
    var width: Float,
    var color: Int
) : Style {

    override fun apply(paint: Paint) {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = width
        paint.color = color
    }
}
