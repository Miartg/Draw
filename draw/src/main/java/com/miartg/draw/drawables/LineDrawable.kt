package com.miartg.draw.drawables

import android.graphics.Canvas
import android.graphics.Paint
import com.miartg.draw.geometry.Line
import com.miartg.draw.geometry.Point
import com.miartg.draw.geometry.Vector
import com.miartg.draw.styles.Stroke

class LineDrawable(override val shape: Line, stroke: Stroke?) : ShapeDrawable(shape, stroke) {

    //----
    //Draw
    //----

    override fun onDraw(canvas: Canvas, paint: Paint) {
        shape.run { canvas.drawLine(start.x, start.y, stop.x, stop.y, paint) }
    }


    //------
    //Create
    //------

    override fun onCreateBegin(point: Point) {
        shape.start.set(point)
    }

    override fun onCreate(point: Point) {
        shape.stop.set(point)
    }

    override fun onCreateEnd(point: Point) {
        //no need complete
    }


    //----
    //Edit
    //----

    override fun onEditBegin(point: Point) {
        snapshot.set(shape)
    }

    override fun onEdit(delta: Vector) {
        shape.set(
            snapshot.start.x + delta.x,
            snapshot.start.y + delta.y,
            snapshot.stop.x + delta.x,
            snapshot.stop.y + delta.y
        )
    }

    override fun onEditEnd(point: Point) {

    }

    companion object {
        private val snapshot = Line()
    }
}