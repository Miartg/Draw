package com.miartg.draw.drawables

import android.graphics.Canvas
import android.graphics.Paint
import com.miartg.draw.geometry.Point
import com.miartg.draw.geometry.Rect
import com.miartg.draw.geometry.Vector
import com.miartg.draw.styles.Solid
import com.miartg.draw.styles.Stroke

class RectDrawable(override val shape: Rect, stroke: Stroke?, solid: Solid?) :
    ShapeDrawable(shape, stroke, solid) {

    //----
    //Draw
    //----

    override fun onDraw(canvas: Canvas, paint: Paint) {
        shape.run { canvas.drawRect(left, top, right, bottom, paint) }
    }

    override fun onCreateBegin(point: Point) {
        shape.left = point.x
        shape.top = point.y
    }

    override fun onCreate(point: Point) {
        shape.right = point.x
        shape.bottom = point.y
    }

    override fun onCreateEnd(point: Point) {
        shape.sort()
    }


    //----
    //Edit
    //----


    override fun onEditBegin(point: Point) {
        snapshot.set(shape)
    }

    override fun onEdit(delta: Vector) {
        shape.set(
            snapshot.left + delta.x,
            snapshot.top + delta.y,
            snapshot.right + delta.x,
            snapshot.bottom + delta.y
        )
    }

    override fun onEditEnd(point: Point) {

    }

    companion object {
        private val snapshot = Rect()
    }
}
