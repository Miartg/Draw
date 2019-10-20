package com.miartg.draw.drawables

import android.graphics.Canvas
import android.graphics.Paint
import com.miartg.draw.creators.Creatable
import com.miartg.draw.geometry.Oval
import com.miartg.draw.geometry.Point
import com.miartg.draw.geometry.Vector
import com.miartg.draw.styles.Solid
import com.miartg.draw.styles.Stroke

class OvalDrawable(override val shape: Oval, stroke: Stroke?, solid: Solid?) :
    ShapeDrawable(shape, stroke, solid), Creatable {

    //----
    //Draw
    //----

    override fun onDraw(canvas: Canvas, paint: Paint) {
        shape.bounds.run { canvas.drawOval(left, top, right, bottom, paint) }
    }


    //------
    //Create
    //------

    override fun createBegin(point: Point) {
        shape.bounds.left = point.x
        shape.bounds.top = point.y
    }

    override fun createUpdate(point: Point) {
        shape.bounds.right = point.x
        shape.bounds.bottom = point.y
    }

    override fun createEnd(point: Point) {
        shape.bounds.sort()
    }


    //----
    //Edit
    //----

    override fun editBegin(point: Point) {
        snapshot.set(shape)
    }

    override fun editUpdate(delta: Vector) {
        shape.bounds.set(
            snapshot.bounds.left + delta.x,
            snapshot.bounds.top + delta.y,
            snapshot.bounds.right + delta.x,
            snapshot.bounds.bottom + delta.y
        )
    }

    override fun editEnd(point: Point) {

    }

    companion object {
        private val snapshot = Oval()
    }
}
