package com.miartg.draw.styles

import android.graphics.Paint

data class Solid(
    var color: Int
) : Style {

    override fun apply(paint: Paint) {
        paint.style = Paint.Style.FILL
        paint.color = color
    }
}
