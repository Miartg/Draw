package com.miartg.draw.drawables

import android.graphics.Canvas
import android.graphics.Paint
import com.miartg.draw.creators.Creatable
import com.miartg.draw.geometry.Oval
import com.miartg.draw.geometry.Point
import com.miartg.draw.styles.Solid
import com.miartg.draw.styles.Stroke

class OvalDrawable(override val shape: Oval, stroke: Stroke?, solid: Solid?) :
    ShapeDrawable(shape, stroke, solid), Creatable {

    override fun onDraw(canvas: Canvas, paint: Paint) {
        shape.bounds.run { canvas.drawOval(left, top, right, bottom, paint) }
    }

    override fun start(point: Point) {
        shape.bounds.left = point.x
        shape.bounds.top = point.y
    }

    override fun stop(point: Point) {
        shape.bounds.right = point.x
        shape.bounds.bottom = point.y
    }

    override fun complete(point: Point) {
        shape.bounds.sort()
    }
}
