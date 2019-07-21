package com.miartg.draw.shapes

import android.graphics.Canvas
import android.graphics.Paint

class Line(
    private val startX: Float,
    private val startY: Float,
    private val stopX: Float,
    private val stopY: Float
) : Shape {

    override fun draw(canvas: Canvas, paint: Paint) {
        canvas.drawLine(startX, startY, stopX, stopY, paint)
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
