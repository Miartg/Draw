package com.miartg.draw.drawables

import android.graphics.Canvas
import android.graphics.Paint
import com.miartg.draw.geometry.Line
import com.miartg.draw.geometry.Point
import com.miartg.draw.styles.Stroke

class LineDrawable(override val shape: Line, stroke: Stroke?) : ShapeDrawable(shape, stroke) {

    override fun onDraw(canvas: Canvas, paint: Paint) {
        shape.run { canvas.drawLine(start.x, start.y, stop.x, stop.y, paint) }
    }

    override fun start(point: Point) {
        shape.start.set(point)
    }

    override fun stop(point: Point) {
        shape.stop.set(point)
    }

    override fun complete(point: Point) {
        //no need complete
    }
}