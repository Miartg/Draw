package com.miartg.draw.shapes

import android.graphics.Canvas
import android.graphics.Paint

class Circle(
    private val cx: Float,
    private val cy: Float,
    private val radius: Float
): Shape {


    override fun draw(canvas: Canvas, paint: Paint) {
        canvas.drawCircle(cx, cy, radius, paint)
    }

    override fun isBelong(x: Float, y: Float): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMove(dx: Float, dy: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
