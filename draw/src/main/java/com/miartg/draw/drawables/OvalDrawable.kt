package com.miartg.draw.drawables

import android.graphics.Canvas
import android.graphics.Paint
import com.miartg.draw.shapes.Oval
import com.miartg.draw.shapes.Point
import com.miartg.draw.styles.Solid
import com.miartg.draw.styles.Stroke

class OvalDrawable(override val shape: Oval, stroke: Stroke?, solid: Solid?)
    : Drawable(shape, stroke, solid) {

    override fun onDraw(canvas: Canvas, paint: Paint) {
        shape.bounds.run { canvas.drawOval(left, top, right, bottom, paint) }
    }

    override fun contains(point: Point, precision: Float): Boolean {
        return super.contains(point, precision)
    }
}