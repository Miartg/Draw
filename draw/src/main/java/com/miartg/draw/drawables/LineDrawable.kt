package com.miartg.draw.drawables

import android.graphics.Canvas
import android.graphics.Paint
import com.miartg.draw.shapes.Line
import com.miartg.draw.styles.Stroke

class LineDrawable(override val shape: Line, stroke: Stroke?) : Drawable(shape, stroke) {

    override fun onDraw(canvas: Canvas, paint: Paint) {
        shape.run { canvas.drawLine(start.x, start.y, stop.x, stop.y, paint) }
    }
}