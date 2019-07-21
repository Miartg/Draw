package com.miartg.draw.shapes

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

class Rectangle(left: Float, top: Float, right: Float, bottom: Float) : Shape {

    private var rect = RectF(left, top, right, bottom).apply { sort() }
    private var drawRect = RectF(rect)

    override fun draw(canvas: Canvas, paint: Paint) {
        canvas.drawRect(drawRect, paint)
    }

    override fun isBelong(x: Float, y: Float): Boolean = rect.contains(x, y)

    override fun onMove(dx: Float, dy: Float) {
        drawRect.set(rect.left + dx, rect.top + dy, rect.right + dx, rect.bottom + dy)
    }

    override fun onUp() {
        rect.set(drawRect)
    }
}
