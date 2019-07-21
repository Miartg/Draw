package com.miartg.draw.shapes

import android.graphics.Canvas
import android.graphics.Paint

interface Shape {

    fun draw(canvas: Canvas, paint: Paint)

    fun isBelong(x: Float, y: Float): Boolean

    fun onMove(dx: Float, dy: Float)

    fun onUp()
}
