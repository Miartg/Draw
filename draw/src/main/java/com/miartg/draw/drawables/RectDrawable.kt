package com.miartg.draw.drawables

import android.graphics.Canvas
import android.graphics.Paint
import com.miartg.draw.geometry.Point
import com.miartg.draw.geometry.Rect
import com.miartg.draw.styles.Solid
import com.miartg.draw.styles.Stroke

class RectDrawable(override val shape: Rect, stroke: Stroke?, solid: Solid?) :
    ShapeDrawable(shape, stroke, solid) {

    override fun onDraw(canvas: Canvas, paint: Paint) {
        shape.run { canvas.drawRect(left, top, right, bottom, paint) }
    }

    override fun start(point: Point) {
        shape.left = point.x
        shape.top = point.y
    }

    override fun stop(point: Point) {
        shape.right = point.x
        shape.bottom = point.y
    }

    override fun complete(point: Point) {
        shape.sort()
    }
}
