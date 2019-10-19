package com.miartg.draw.styles

import android.graphics.Paint

data class Stroke(
    var width: Float,
    var color: Int,
    var cap: Cap
) : Style {

    override fun apply(paint: Paint) {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = width
        paint.strokeCap = cap.androidCup
        paint.color = color
    }

    private val Cap.androidCup
        get() = when (this) {
            Cap.BUTT -> Paint.Cap.BUTT
            Cap.SQUARE -> Paint.Cap.SQUARE
            Cap.ROUND -> Paint.Cap.ROUND
        }
}
