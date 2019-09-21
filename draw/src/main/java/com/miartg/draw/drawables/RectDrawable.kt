package com.miartg.draw.drawables

import android.graphics.Canvas
import android.graphics.Paint
import com.miartg.draw.shapes.Line
import com.miartg.draw.shapes.Rect
import com.miartg.draw.styles.Solid
import com.miartg.draw.styles.Stroke

class RectDrawable(override val shape: Rect, stroke: Stroke?, solid: Solid?) : Drawable(shape, stroke, solid) {

    override fun onDraw(canvas: Canvas, paint: Paint) {
        shape.run { canvas.drawRect(left, top, right, bottom, paint) }
    }
}
